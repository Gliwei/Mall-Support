package com.lw.productunit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
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
import com.lw.productunit.entity.Product;
import com.lw.productunit.entity.Property;
import com.lw.productunit.service.ProductService;
import com.lw.productunit.service.PropertyService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController<Product, String>{
	
	@Autowired ProductService productService;
	@Autowired PropertyService propertyService;
	
	@RequestMapping("/addPropertyPage")
	public String addPropertyPage(String productId, Model m) {
		Product product = productService.findById(productId);
		product.setProperties(new HashSet<Property>(propertyService.findByProductId(productId)));
		m.addAttribute("entity", product);
		return "productunit/product-edit-property";
	}
	
	@RequestMapping("/editOrSaveProperty")
	public @ResponseBody Map<String, Object> editOrSaveProperty(Property entity) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, String> msg = entity.validation();
		if(msg==null || msg.isEmpty()){
			propertyService.save(entity);
			jsonMap.put("err", 0);
			jsonMap.put("msg", "success");
			jsonMap.put("id", entity.getId());
		} else {
			ObjectMapper mapper = new ObjectMapper();
			jsonMap.put("err", msg.size());
			jsonMap.put("msg", mapper.writeValueAsString(msg));
		}
		return jsonMap;
	}
	
	@RequestMapping("/delProperty")
	public @ResponseBody Map<String, Object> delProperty(Property entity) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		propertyService.delete(entity);
		jsonMap.put("err", 0);
		jsonMap.put("msg", "success");
		return jsonMap;
	}
	
	@Override
	protected BaseService<Product, String> getService() {
		return productService;
	}
	
	@Override
	protected String getEditPage() {
		return "productunit/product";
	}

	@Override
	protected String getListPage() {
		return "productunit/product-list";
	}

	@Override
	protected String getSelectPage() {
		return "productunit/product-select";
	}
	
	 public static void main(String[] args) {
			String applyUserName = "stephanie";
			String loginUserName = "stephanie";
			if(loginUserName == null || !loginUserName.equals(applyUserName)) {
				System.out.println("NOT");
			} else {
				System.out.println("PASS");
			}
		}
}
