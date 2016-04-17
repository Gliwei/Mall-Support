package com.lw.productunit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.productunit.entity.Property;
import com.lw.productunit.entity.Propertyitem;
import com.lw.productunit.service.PropertyService;
import com.lw.productunit.service.PropertyitemService;

@Controller
@RequestMapping("/property")
public class PropertyController extends BaseController<Property, Integer>{
	
	@Autowired PropertyService propertyService;

	@Autowired PropertyitemService propertyitemService;
	
	@Override
	public String save(Property entity, Model m) throws JsonGenerationException ,JsonMappingException ,IOException {
		super.save(entity, m);
		return editItemPage(entity.getId(), m);
	};
	
	@RequestMapping("/editItemPage")
	public String editItemPage(Integer id, Model m) {
		Property entity = propertyService.findById(id);
		m.addAttribute("entity", entity);
		return "productunit/propertyitem";
	}
	
	@RequestMapping("/saveItem")
	public @ResponseBody Map<String, Object> saveItem(Propertyitem entity) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, String> msg = entity.validation();
		if(msg==null || msg.isEmpty()){
			propertyitemService.save(entity);
			jsonMap.put("state", "success");
		} else {
			ObjectMapper mapper = new ObjectMapper();
			jsonMap.put("state", "fail");
			jsonMap.put("msg", mapper.writeValueAsString(msg));
		}
		return jsonMap;
	}
	
	@Override
	protected BaseService<Property, Integer> getService() {
		return propertyService;
	}

	@Override
	protected String getEditPage() {
		return "productunit/property";
	}

	@Override
	protected String getListPage() {
		return "productunit/property-list";
	}

	@Override
	protected String getSelectPage() {
		return "productunit/property-select";
	}
	
}
