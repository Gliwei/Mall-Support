package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.Commodity2specitemDao;
import com.lw.productunit.entity.Commodity2specitem;

@Service
public class Commodity2specitemService extends BaseService<Commodity2specitem, Integer>{
	@Autowired
	Commodity2specitemDao commodity2specitemDao;

	@Override
	protected BaseDao<Commodity2specitem, Integer> getEntityDao() {
		return commodity2specitemDao;
	}

	public void saveOnNotExist(Commodity2specitem entity) {
		List<Commodity2specitem> s2c = commodity2specitemDao.query(entity.getCommodity().getId(), entity.getSpecitem().getId());
		if(s2c==null || s2c.isEmpty()){
			commodity2specitemDao.saveOrUpdate(entity);
		}
	}
	
	public void delete(Commodity2specitem entity) {
		List<Commodity2specitem> s2cs = commodity2specitemDao.query(entity.getCommodity().getId(), entity.getSpecitem().getId());
		if(s2cs!=null && !s2cs.isEmpty()){
			for(Commodity2specitem s2c:s2cs){
				commodity2specitemDao.delete(s2c);
			}
		}
	}

}
