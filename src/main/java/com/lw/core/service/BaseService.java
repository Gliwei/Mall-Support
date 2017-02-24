package com.lw.core.service;

import java.io.Serializable;
import java.util.List;

import com.lw.core.dao.BaseDao;
import com.lw.core.entity.BaseEntity;
import com.lw.core.util.Pageable;

public abstract class BaseService<T extends BaseEntity, ID extends Serializable> {
	
	/** 泛型对应的Class定义 */
	// private Class<T> clazz;
	
	/** 子类设置具体的DAO对象实例 */
    abstract protected BaseDao<T, ID> getEntityDao();
	
	public Pageable<T> likeSearch(String fields, String value, Integer pageNo){
		Pageable<T> pageable = new Pageable<T>(pageNo);
		return getEntityDao().likeSearch(fields, value, pageable);
	}

	public T findById(ID id){
		return getEntityDao().findById(id);
	}
	
	public List<T> findAll() {
		return getEntityDao().findAll();
	}

	public void save(T entity) {
		getEntityDao().saveOrUpdate(entity);
	}
	
	public Pageable<T> findByPage(int pageNo){
		Pageable<T> pageable = new Pageable<T>(pageNo);
		return getEntityDao().findByPage(pageable);
	}
	
	public Pageable<T> findByPage(int pageNo, int pageSize){
		Pageable<T> pageable = new Pageable<T>(pageNo, pageSize);
		return getEntityDao().findByPage(pageable);
	}
	
	public void delete(T entity){
		getEntityDao().delete(entity);
	}
	
}
