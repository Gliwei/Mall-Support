package com.lw.productunit.controller;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.util.Pageable;
import com.lw.productunit.entity.Category;
import com.lw.productunit.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryService categoryService;
	
	@RequestMapping("/list")
	public String list(){
		return "redirect:/category/list/1";
	}
	
	@RequestMapping("/list/{p}")
	public String list(@PathVariable("p") Integer pageNo, Model m){
		// pageNo = pageNo==null?1:pageNo;
		Pageable<Category> pageable = categoryService.findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		return "productunit/category-list";
	}
	
	@RequestMapping("/editpage")
	public String editPage(Model m, Integer id){
		if(id!=null){
			Category category = categoryService.findById(id);
			m.addAttribute("category", category);
		}
		m.addAttribute("msg", "");
		return "productunit/category";
	}
	
	@RequestMapping("/save")
	public String save(Category category, Model m) throws JsonGenerationException, JsonMappingException, IOException{
		Map<String, String> msg = category.validation();
		if(msg==null || msg.isEmpty()){
			category.setCategory(null);
			categoryService.save(category);
			m.addAttribute("msg", "Success");
			return "productunit/category";
		}else{
			ObjectMapper mapper = new ObjectMapper();
			m.addAttribute("msg", mapper.writeValueAsString(msg));
			m.addAttribute("category", category);
			return "productunit/category";
		}
	}
}
