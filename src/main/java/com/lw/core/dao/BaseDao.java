package com.lw.core.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.lw.core.entity.BaseEntity;

public class BaseDao<T extends BaseEntity> {
	@Autowired HibernateTemplate hibernateTemplate;
	
	public void saveOrUpdate(T entity){
		if(entity==null){
			throw new NullPointerException(this.getClass().getName()+" saveOrUpdate param entity is null");
		}
		Date now = new Date();
		if(entity.isNew()){
			entity.setCreateTime(now);
			entity.setVersion(0);
		}
		entity.setLastModifyTime(now);
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	/**
	 * 
	 * @param entity 只是为了获取类名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(T entity){
		return hibernateTemplate.find("from "+entity.getClass().getCanonicalName());
	}
	
}
