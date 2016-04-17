package com.lw.productunit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Commodity2propertyitem;

@Repository
public class Commodity2propertyitemDao extends BaseDao<Commodity2propertyitem, Integer> {

	public Commodity2propertyitemDao() {
		super(Commodity2propertyitem.class);
	}

	@SuppressWarnings("unchecked")
	public List<Commodity2propertyitem> query(Integer commodityId, Integer propertyitemId) {
		
		List<Commodity2propertyitem> list = getEm().createQuery("from "+Commodity2propertyitem.class.getSimpleName()
						+" where commodity.id="+commodityId+" and propertyitem.id="+propertyitemId).getResultList();
		return list;
	}

}
