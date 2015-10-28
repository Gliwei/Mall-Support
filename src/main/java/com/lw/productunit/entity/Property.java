package com.lw.productunit.entity;

import java.util.HashSet;
import java.util.Map;
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
 * Property generated by hbm2java
 */
@Entity
@Table(name = "property", catalog = "mall")
public class Property extends BaseEntity {

	private static final long serialVersionUID = 9103800514581523227L;
	
	private Category category;
	private String name;
	private Set<Propertyitem> propertyitems = new HashSet<Propertyitem>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "property")
	public Set<Propertyitem> getPropertyitems() {
		return this.propertyitems;
	}

	public void setPropertyitems(Set<Propertyitem> propertyitems) {
		this.propertyitems = propertyitems;
	}

	@Override
	public Map<String, String> validation() {
		// TODO Auto-generated method stub
		return null;
	}

}
