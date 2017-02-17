package com.lw.productunit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Property;

@Repository
public class PropertyDao extends BaseDao<Property, String> {

	public PropertyDao() {
		super(Property.class);
	}

	@SuppressWarnings("unchecked")
	public List<Property> findByProductId(String id) {
		return getEm().createQuery("from "+Property.class.getSimpleName()+" where product.id='"+id+"'").getResultList();
	}

}
