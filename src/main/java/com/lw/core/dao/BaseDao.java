package com.lw.core.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParser.NumberType;

import com.lw.core.entity.BaseEntity;
import com.lw.core.util.Operator;
import com.lw.core.util.Pageable;
import com.lw.core.util.QueryCondition;

public class BaseDao<T extends BaseEntity, ID extends Serializable> {

	@PersistenceContext EntityManager em;

	private Class<T> clazz;

	public BaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void saveOrUpdate(T entity) {
		if (entity == null) {
			throw new NullPointerException(this.getClass().getName()
					+ " saveOrUpdate param entity is null");
		}
		Date now = new Date();
		entity.setLastModifyTime(now);
		if (entity.isNew()) {
			entity.setCreateTime(now);
			entity.setVersion(0);
			em.persist(entity);
		}else{
			em.merge(entity);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("from "+clazz.getSimpleName()).getResultList();
	}
	
	public T findById(ID id){
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public Pageable<T> findByPage(Pageable<T> page) {
		List<T> list = em.createQuery("from "+clazz.getSimpleName())
				.setFirstResult(page.getStartRow()).setMaxResults(page.getRows()).getResultList();
		page.setList(list);
		return page;
	}
	
	
	@SuppressWarnings("unchecked")
	public Pageable<T> findByPage(Pageable<T> page, QueryCondition query) {
		String sql = "from " + clazz.getSimpleName();
		if(StringUtils.isNotBlank(query.getSql())){
			sql += " where "+query.getSql();
		}
		System.out.println(sql);
		List<T> list = em.createQuery(sql)
				.setFirstResult(page.getStartRow()).setMaxResults(page.getRows()).getResultList();
		page.setList(list);
		return page;
	}
}
