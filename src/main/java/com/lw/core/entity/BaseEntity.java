package com.lw.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

@MappedSuperclass
public abstract class BaseEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 6960810129594372036L;
	
	Integer id;
	Integer version;
	String lastOperator;// 操作者
	Date createTime;
	Date lastModifyTime;

	@Transient
	public abstract Map<String, String> validation();
	
	@Transient
	public boolean isNew() {
		Serializable id = getId();
		return id == null || StringUtils.isBlank(String.valueOf(id));
	}
	
	// public abstract String validation();

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
