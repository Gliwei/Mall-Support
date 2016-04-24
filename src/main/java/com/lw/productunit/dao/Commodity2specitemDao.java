package com.lw.productunit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Commodity2specitem;

@Repository
public class Commodity2specitemDao extends BaseDao<Commodity2specitem, String> {

	public Commodity2specitemDao() {
		super(Commodity2specitem.class);
	}

	@SuppressWarnings("unchecked")
	public List<Commodity2specitem> query(String commodityId, String specitemId) {
		
		List<Commodity2specitem> list = getEm().createQuery("from "+Commodity2specitem.class.getSimpleName()
						+" where commodity.id='"+commodityId+"' and specitem.id='"+specitemId+"'").getResultList();
		return list;
	}

}
