package com.lw.productunit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Spec;

@Repository
public class SpecDao extends BaseDao<Spec, String> {

	public SpecDao() {
		super(Spec.class);
	}

	@SuppressWarnings("unchecked")
	public List<Spec> findByCategoryId(String id) {
		return getEm().createQuery("from "+Spec.class.getSimpleName()+" where category.id='"+id+"'").getResultList();
	}

}
