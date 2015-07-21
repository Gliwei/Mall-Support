package com.lw.core.entity;

import java.util.Date;

public class BaseEntity {
	private Integer id;
	
	private Long version;
	private String lastOperator;//操作者
	private Date createTime;
	private Date lastModifyTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getLastOperator() {
		return lastOperator;
	}
	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
}
