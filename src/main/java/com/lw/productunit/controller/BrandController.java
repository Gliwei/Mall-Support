package com.lw.productunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.core.util.Pageable;
import com.lw.productunit.entity.Brand;
import com.lw.productunit.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired BrandService brandService;
	
	@RequestMapping("/list/{p}.json")
	public @ResponseBody List<Brand> list(@PathVariable("p") int pageNo){
		return brandService.findAll();
	}
	
	@RequestMapping("/list/{p}")
	public String list(@PathVariable("p") int pageNo, Model m){
		Pageable<Brand> pageable = brandService.findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		return "brand-list";
	}
	
	@RequestMapping("/addpage")
	public String addPage(Model m, Integer id){
		if(id!=null){
			Brand brand = brandService.findById(id);
			m.addAttribute("brand", brand);
		}
		m.addAttribute("msg", "");
		return "brand";
	}
	
	@RequestMapping("/add")
	public String add(Brand brand, Model m){
		brandService.save(brand);
		m.addAttribute("msg", "Success");
		return "brand";
	}
}
