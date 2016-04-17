package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.Commodity2propertyitemDao;
import com.lw.productunit.entity.Commodity2propertyitem;

@Service
public class Commodity2propertyitemService extends BaseService<Commodity2propertyitem, Integer>{
	@Autowired
	Commodity2propertyitemDao commodity2propertyitemDao;

	@Override
	protected BaseDao<Commodity2propertyitem, Integer> getEntityDao() {
		return commodity2propertyitemDao;
	}

	public void saveOnNotExist(Commodity2propertyitem entity) {
		List<Commodity2propertyitem> s2p = commodity2propertyitemDao.query(entity.getCommodity().getId(), entity.getPropertyitem().getId());
		if(s2p==null || s2p.isEmpty()){
			commodity2propertyitemDao.saveOrUpdate(entity);
		}
	}
	
	public void delete(Commodity2propertyitem entity) {
		List<Commodity2propertyitem> s2ps = commodity2propertyitemDao.query(entity.getCommodity().getId(), entity.getPropertyitem().getId());
		if(s2ps!=null && !s2ps.isEmpty()){
			for(Commodity2propertyitem s2p:s2ps){
				commodity2propertyitemDao.delete(s2p);
			}
		}
	}

}
