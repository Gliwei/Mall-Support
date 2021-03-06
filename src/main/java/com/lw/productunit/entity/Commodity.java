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

@Entity
@Table(name = "commodity", catalog = "mall")
public class Commodity extends BaseEntity {

	private static final long serialVersionUID = -6019445061790987434L;
	
	private Product product;
	private String sku;
	private String title;
	private String subtitle;
	private long salePrice;
	private long costPrice;
	private String mainPicture;
	private String htmlDescription;
	private Set<Commodity2specitem> commodity2specitems = new HashSet<Commodity2specitem>(0);
	private Set<Commodity2propertyitem> commodity2propertyitems = new HashSet<Commodity2propertyitem>(0);

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Column(name = "sku", nullable = false, length = 30)
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	@Column(name = "salePrice", nullable = false, precision = 10, scale = 0)
	public long getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(long salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "costPrice", nullable = false, precision = 10, scale = 0)
	public long getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(long costPrice) {
		this.costPrice = costPrice;
	}

	@Column(name = "mainPicture", nullable = false, length = 100)
	public String getMainPicture() {
		return this.mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}

	@Column(name = "htmlDescription", length = 16777215)
	public String getHtmlDescription() {
		return this.htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "commodity")
	public Set<Commodity2specitem> getCommodity2specitems() {
		return this.commodity2specitems;
	}

	public void setCommodity2specitems(Set<Commodity2specitem> commodity2specitems) {
		this.commodity2specitems = commodity2specitems;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "commodity")
	public Set<Commodity2propertyitem> getCommodity2propertyitems() {
		return this.commodity2propertyitems;
	}

	public void setCommodity2propertyitems(Set<Commodity2propertyitem> commodity2propertyitems) {
		this.commodity2propertyitems = commodity2propertyitems;
	}

	@Override
	public Map<String, String> validation() {
		// TODO Auto-generated method stub
		return null;
	}

}
