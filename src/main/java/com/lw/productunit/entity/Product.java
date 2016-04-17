package com.lw.productunit.entity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lw.core.entity.BaseEntity;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "mall")
public class Product extends BaseEntity {

	private static final long serialVersionUID = 7599772729394822540L;
	
	private Category category;
	private Brand brand;
	private String spu;
	private String title;
	private String subtitle;
	private String htmlDescription;
	private Set<Commodity> commodities = new HashSet<Commodity>(0);

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brandId")
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "spu", nullable = false, length = 30)
	public String getSpu() {
		return this.spu;
	}

	public void setSpu(String spu) {
		this.spu = spu;
	}

	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "subtitle", length = 100)
	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Column(name = "htmlDescription", length = 16777215)
	public String getHtmlDescription() {
		return this.htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade=CascadeType.ALL)
	public Set<Commodity> getCommodities() {
		return this.commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

	@Override
	public Map<String, String> validation() {
		// TODO Auto-generated method stub
		return null;
	}

}
