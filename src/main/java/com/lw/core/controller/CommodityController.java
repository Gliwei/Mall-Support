package com.lw.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.core.entity.Commodity;
import com.lw.core.service.CommodityService;

@Controller
@RequestMapping("/c")
public class CommodityController {
	
	@Autowired CommodityService commodityService;
	
	@RequestMapping("/list.json")
	public @ResponseBody List<Commodity> list(){
		System.out.println("CommodityController.list()"+"-JSON");
		return commodityService.findAll();
	}
	
	@RequestMapping("/list")
	public String list(Model m){
		System.out.println("CommodityController.list()");
		m.addAttribute("msg", "WELCOM");
		return "index";
	}
}
