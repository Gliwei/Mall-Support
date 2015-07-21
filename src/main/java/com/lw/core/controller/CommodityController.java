package com.lw.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.core.entity.Commodity;

@Controller
@RequestMapping("/c")
public class CommodityController {
	
	@RequestMapping("/list.json")
	public @ResponseBody List<Commodity> list(){
		System.out.println("CommodityController.list()");
		List<Commodity> list = new ArrayList<Commodity>();
		for(int i=0; i<10; i++){
			Commodity c = new Commodity();
			c.setId(i);
			c.setTitle("iPhone"+i);
			list.add(c);
		}
		return list;
	}
	
	@RequestMapping("/list")
	public String list(Model m){
		System.out.println("CommodityController.list()");
		m.addAttribute("msg", "WELCOM");
		return "index";
	}
}
