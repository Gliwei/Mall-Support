package com.lw.core.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.entity.BaseEntity;
import com.lw.core.service.BaseService;
import com.lw.core.util.Pageable;

public abstract class BaseController<T extends BaseEntity, ID extends Serializable> {
	
	/** 子类设置具体的DAO对象实例 */
    abstract protected BaseService<T, ID> getService();
    
    abstract protected String getEditPage();
    abstract protected String getListPage();
    abstract protected String getSelectPage();
    
    @RequestMapping("/search")
	public String search(String fields, String kw, Integer pageNo, Model m){
		Pageable<T> pageable = getService().likeSearch(fields, kw, pageNo);
		m.addAttribute("pageable", pageable);
		m.addAttribute("kw", kw);
		return getListPage();
	}
    
    @RequestMapping("/select/{p}")
	public String select(Model m, @PathVariable("p") Integer pageNo, String f){
		Pageable<T> pageable = getService().findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		m.addAttribute("f", f);
		return getSelectPage();
	}
	
	@RequestMapping("/list")
	public String list(Model m, String fields, String kw){
		return list(1, m, fields, kw);
	}
	
	@RequestMapping("/list/{p}")
	public String list(@PathVariable("p") Integer pageNo, Model m, String fields, String kw){
		// pageNo = pageNo==null?1:pageNo;
		if(StringUtils.isNotBlank(fields) && StringUtils.isNotBlank(kw)){
			return search(fields, kw, pageNo, m);
		}
		Pageable<T> pageable = getService().findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		return getListPage();
	}
	
	@RequestMapping("/editpage")
	public String editPage(Model m, ID id){
		if(id!=null){
			T entity = getService().findById(id);
			m.addAttribute("entity", entity);
		}
		m.addAttribute("msg", "");
		return getEditPage();
	}
	
	@RequestMapping("/save")
	public String save(T entity, Model m) throws JsonGenerationException, JsonMappingException, IOException{
		System.out.println(">>>:"+entity.toString());
		Map<String, String> msg = entity.validation();
		if(msg==null || msg.isEmpty()){
			getService().save(entity);
			m.addAttribute("msg", "Success");
		} else {
			ObjectMapper mapper = new ObjectMapper();
			m.addAttribute("msg", mapper.writeValueAsString(msg));
			m.addAttribute("entity", entity);
		}
		return getEditPage();
	}
}
