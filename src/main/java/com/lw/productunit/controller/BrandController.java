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
import com.lw.productunit.entity.Brand;
import com.lw.productunit.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired BrandService brandService;
	
	@RequestMapping("/list")
	public String list(){
		return "redirect:/brand/list/1";
	}
	
	@RequestMapping("/list/{p}")
	public String list(@PathVariable("p") Integer pageNo, Model m){
		// pageNo = pageNo==null?1:pageNo;
		Pageable<Brand> pageable = brandService.findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		return "productunit/brand-list";
	}
	
	@RequestMapping("/editpage")
	public String editPage(Model m, Integer id){
		if(id!=null){
			Brand brand = brandService.findById(id);
			m.addAttribute("brand", brand);
		}
		m.addAttribute("msg", "");
		return "productunit/brand";
	}
	
	@RequestMapping("/save")
	public String save(Brand brand, Model m) throws JsonGenerationException, JsonMappingException, IOException{
		Map<String, String> msg = brand.validation();
		if(!msg.isEmpty()){
			ObjectMapper mapper = new ObjectMapper();
			m.addAttribute("msg", mapper.writeValueAsString(msg));
			m.addAttribute("brand", brand);
			return "productunit/brand";
		}
		brandService.save(brand);
		m.addAttribute("msg", "Success");
		return "productunit/brand";
	}
}
