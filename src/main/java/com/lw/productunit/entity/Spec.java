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
 * Spec generated by hbm2java
 */
@Entity
@Table(name = "spec", catalog = "mall")
public class Spec extends BaseEntity {

	private static final long serialVersionUID = -3647540065000620811L;
	
	private Category category;
	private String name;
	private Set<Specitem> specitems = new HashSet<Specitem>(0);

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "spec")
	public Set<Specitem> getSpecitems() {
		return this.specitems;
	}

	public void setSpecitems(Set<Specitem> specitems) {
		this.specitems = specitems;
	}

}
