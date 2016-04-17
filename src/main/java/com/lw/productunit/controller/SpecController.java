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
import com.lw.productunit.entity.Spec;
import com.lw.productunit.entity.Specitem;
import com.lw.productunit.service.SpecService;
import com.lw.productunit.service.SpecitemService;

@Controller
@RequestMapping("/spec")
public class SpecController extends BaseController<Spec, Integer>{
	
	@Autowired SpecService specService;

	@Autowired SpecitemService specitemService;
	
	@Override
	public String save(Spec entity, Model m) throws JsonGenerationException ,JsonMappingException ,IOException {
		super.save(entity, m);
		return editItemPage(entity.getId(), m);
	};
	
	@RequestMapping("/editItemPage")
	public String editItemPage(Integer id, Model m) {
		Spec entity = specService.findById(id);
		m.addAttribute("entity", entity);
		return "productunit/specitem";
	}
	
	@RequestMapping("/saveItem")
	public @ResponseBody Map<String, Object> editItemPage(Specitem entity) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, String> msg = entity.validation();
		if(msg==null || msg.isEmpty()){
			specitemService.save(entity);
			jsonMap.put("state", "success");
		} else {
			ObjectMapper mapper = new ObjectMapper();
			jsonMap.put("state", "fail");
			jsonMap.put("msg", mapper.writeValueAsString(msg));
		}
		return jsonMap;
	}
	
	@Override
	protected BaseService<Spec, Integer> getService() {
		return specService;
	}

	@Override
	protected String getEditPage() {
		return "productunit/spec";
	}

	@Override
	protected String getListPage() {
		return "productunit/spec-list";
	}

	@Override
	protected String getSelectPage() {
		return "productunit/specitem-select";
	}
	
}
