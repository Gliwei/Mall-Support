package com.lw.productunit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lw.core.entity.BaseEntity;

/**
 * Commodity2propertyitem generated by hbm2java
 */
@Entity
@Table(name = "commodity2propertyitem", catalog = "mall")
public class Commodity2propertyitem extends BaseEntity {

	private static final long serialVersionUID = -7505036257199880155L;
	
	private Commodity commodity;
	private Propertyitem propertyitem;
	private String propertyName;
	private String itemName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commodityId")
	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "propertyItemId")
	public Propertyitem getPropertyitem() {
		return this.propertyitem;
	}

	public void setPropertyitem(Propertyitem propertyitem) {
		this.propertyitem = propertyitem;
	}

	@Column(name = "propertyName", length = 30)
	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Column(name = "itemName", length = 30)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}