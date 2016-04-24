package com.lw.core.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;

import com.lw.core.entity.BaseEntity;
import com.lw.core.util.Pageable;
import com.lw.core.util.QueryCondition;

public class BaseDao<T extends BaseEntity, ID extends Serializable> {

	@PersistenceContext EntityManager em;

	private Class<T> clazz;

	public BaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	@SuppressWarnings("unchecked")
	public Pageable<T> likeSearch(String fields, String value, Pageable<T> page){
		// fields = id/name/enName/description
		// value = nike
		String[] fieldArr = fields.split("/");
		if(fieldArr.length<1)return null;
		
		StringBuilder where = new StringBuilder(" where ");
		for(String field : fieldArr){
			where.append(field).append(" like ").append("'%"+value+"%'").append(" OR ");
		}
		String sqlWhere = where.substring(0, where.lastIndexOf("OR"));
		
		page.setCount(count(sqlWhere));
		
		List<T> list = em.createQuery("from "+clazz.getSimpleName()+" "+sqlWhere)
				.setFirstResult(page.getStartRow()).setMaxResults(page.getRows()).getResultList();
		page.setList(list);
		return page;
	}

	public int count(String sqlWhere){
		Object count = em.createQuery("select count(id) from "+clazz.getSimpleName()+ " "+sqlWhere).getSingleResult();
		return Integer.parseInt(count.toString());
	}
	
	public int count(){
		Object count = em.createQuery("select count(id) from "+clazz.getSimpleName()).getSingleResult();
		return Integer.parseInt(count.toString());
	}
	
	public void saveOrUpdate(T entity) {
		if (entity == null) {
			throw new NullPointerException(this.getClass().getName()
					+ " saveOrUpdate param entity is null");
		}
		Date now = new Date();
		entity.setLastModifyTime(now);
		if (entity.isNew()) {
			entity.setId(null);// 解决detached entity passed to persist
			entity.setCreateTime(now);
			entity.setVersion(0);
			em.persist(entity);
		}else{
			int version = entity.getVersion()==null?0:entity.getVersion();
			entity.setVersion(++version);
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
		int count = this.count();
		if(count <= 0) return page;
		page.setCount(count);
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

	public void delete(T entity){
		em.remove(entity);
	}
}
