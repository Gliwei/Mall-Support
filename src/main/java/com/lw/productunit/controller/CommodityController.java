package com.lw.productunit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.productunit.entity.Commodity;
import com.lw.productunit.entity.Commodity2propertyitem;
import com.lw.productunit.entity.Commodity2specitem;
import com.lw.productunit.entity.Property;
import com.lw.productunit.entity.Propertyitem;
import com.lw.productunit.entity.Spec;
import com.lw.productunit.entity.Specitem;
import com.lw.productunit.service.Commodity2propertyitemService;
import com.lw.productunit.service.Commodity2specitemService;
import com.lw.productunit.service.CommodityService;
import com.lw.productunit.service.PropertyService;
import com.lw.productunit.service.SpecService;

@Controller
@RequestMapping("/commodity")
public class CommodityController extends BaseController<Commodity, Integer>{
	
	@Autowired CommodityService commodityService;

	@Autowired Commodity2specitemService commodity2specitemService;
	
	@Autowired SpecService specService;
	
	@Autowired Commodity2propertyitemService commodity2propertyitemService;
	
	@Autowired PropertyService propertyService;
	
	@RequestMapping("/editSpecPage")
	public String editItemPage(Integer id, Model m) {
		Commodity entity = commodityService.findById(id);
		m.addAttribute("entity", entity);
		List<Spec> specList = specService.findByCategoryId(entity.getProduct().getCategory().getId());
		m.addAttribute("specList", specList);
		return "productunit/commodity2specitem";
	}
	
	@RequestMapping("/saveC2S")
	public @ResponseBody Map<String, Object> saveC2S(Commodity commodity, Integer[] itemIds) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		for(Integer itemId : itemIds){
			Commodity2specitem c2s = new Commodity2specitem();
			Specitem specitem = new Specitem();
			specitem.setId(itemId);
			c2s.setCommodity(commodity);
			c2s.setSpecitem(specitem);
			commodity2specitemService.saveOnNotExist(c2s);
		}
		jsonMap.put("state", "success");
		return jsonMap;
	}
	
	@RequestMapping("/delC2S")
	public @ResponseBody Map<String, Object> deleteC2S(Commodity commodity, Integer[] itemIds) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		for(Integer itemId : itemIds){
			Commodity2specitem c2s = new Commodity2specitem();
			Specitem specitem = new Specitem();
			specitem.setId(itemId);
			c2s.setCommodity(commodity);
			c2s.setSpecitem(specitem);
			commodity2specitemService.delete(c2s);
		}
		jsonMap.put("state", "success");
		return jsonMap;
	}
	
	@RequestMapping("/editPropertyPage")
	public String editPropertyPage(Integer id, Model m) {
		Commodity entity = commodityService.findById(id);
		m.addAttribute("entity", entity);
		List<Property> propertyList = propertyService.findByCategoryId(entity.getProduct().getCategory().getId());
		m.addAttribute("propertyList", propertyList);
		return "productunit/commodity2propertyitem";
	}
	
	@RequestMapping("/saveC2P")
	public @ResponseBody Map<String, Object> saveC2P(Commodity commodity, Integer[] itemIds) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		for(Integer itemId : itemIds){
			Commodity2propertyitem c2s = new Commodity2propertyitem();
			Propertyitem item = new Propertyitem();
			item.setId(itemId);
			c2s.setCommodity(commodity);
			c2s.setPropertyitem(item);
			commodity2propertyitemService.saveOnNotExist(c2s);
		}
		jsonMap.put("state", "success");
		return jsonMap;
	}
	
	@RequestMapping("/delC2P")
	public @ResponseBody Map<String, Object> deleteC2P(Commodity commodity, Integer[] itemIds) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		for(Integer itemId : itemIds){
			Commodity2propertyitem c2s = new Commodity2propertyitem();
			Propertyitem item = new Propertyitem();
			item.setId(itemId);
			c2s.setCommodity(commodity);
			c2s.setPropertyitem(item);
			commodity2propertyitemService.delete(c2s);
		}
		jsonMap.put("state", "success");
		return jsonMap;
	}
	
	@Override
	protected BaseService<Commodity, Integer> getService() {
		return commodityService;
	}

	@Override
	protected String getEditPage() {
		return "productunit/commodity";
	}

	@Override
	protected String getListPage() {
		return "productunit/commodity-list";
	}

	@Override
	protected String getSelectPage() {
		return "productunit/commodity-select";
	}
	
}
