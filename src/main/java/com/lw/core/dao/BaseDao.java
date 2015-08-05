package com.lw.core.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lw.core.entity.BaseEntity;
import com.lw.core.util.Pageable;
import com.lw.core.util.Query;

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
	
	
	public Pageable<T> findByPage(Pageable<T> page, List<Query> querys) {
		List<T> list = em.createQuery("from "+clazz.getSimpleName())
				.setFirstResult(page.getStartRow()).setMaxResults(page.getRows()).getResultList();
		page.setList(list);
		return page;
	}
	
	public static String getSQL(List<Query> querys, String ao){
		StringBuilder sql = new StringBuilder();
		for(Query q : querys){
			sql.append(" ");
			sql.append(q.getPropertyName());
			sql.append(q.getOperator());
			sql.append(q.getPropertyValue());
			sql.append(" ");
			sql.append(ao);
		}
		
		return sql.substring(0, sql.lastIndexOf(ao)).toString();
	}
	
	public static void main(String[] args) {
		List<Query> list = new ArrayList<Query>();
		Query q1 = new Query("title", "=", "iPhone");
		Query q2 = new Query("price", "<", "4800");
		Query q3 = new Query("color", "=", "深空灰");
		
		list.add(q1);
		list.add(q2);
		list.add(q3);
		
		String sql = BaseDao.getSQL(list, "OR");
		System.err.println(sql);
	}
}
