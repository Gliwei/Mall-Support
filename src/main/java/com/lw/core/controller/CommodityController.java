package com.lw.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.core.entity.Commodity;
import com.lw.core.service.CommodityService;
import com.lw.core.util.Pageable;

@Controller
@RequestMapping("/c")
public class CommodityController {
	
	@Autowired CommodityService commodityService;
	
	@RequestMapping("/list/{p}.json")
	public @ResponseBody List<Commodity> list(@PathVariable("p") int pageNo){
		System.out.println("CommodityController.list()"+"-JSON");
		return commodityService.findAll();
	}
	
	@RequestMapping("/list/{p}")
	public String list(@PathVariable("p") int pageNo, Model m){
		System.out.println("CommodityController.list()");
		m.addAttribute("msg", "WELCOM");
		
		Pageable<Commodity> pageable = commodityService.findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		return "index";
	}
}
