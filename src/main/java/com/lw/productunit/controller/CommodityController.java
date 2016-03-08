package com.lw.productunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.productunit.entity.Commodity;
import com.lw.productunit.service.CommodityService;

@Controller
@RequestMapping("/commodity")
public class CommodityController extends BaseController<Commodity, Integer>{
	
	@Autowired CommodityService commodityService;

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
