package com.lw.productunit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lw.core.entity.BaseEntity;

/**
 * Propertyitem generated by hbm2java
 */
@Entity
@Table(name = "propertyitem", catalog = "mall")
public class Propertyitem extends BaseEntity {

	private static final long serialVersionUID = 3280518321207539518L;
	
	private Property property;
	private String itemName;
	private Set<Commodity2propertyitem> commodity2propertyitems = new HashSet<Commodity2propertyitem>(0);


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "propertyId")
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Column(name = "itemName", nullable = false, length = 30)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyitem")
	public Set<Commodity2propertyitem> getCommodity2propertyitems() {
		return this.commodity2propertyitems;
	}

	public void setCommodity2propertyitems(Set<Commodity2propertyitem> commodity2propertyitems) {
		this.commodity2propertyitems = commodity2propertyitems;
	}

}
