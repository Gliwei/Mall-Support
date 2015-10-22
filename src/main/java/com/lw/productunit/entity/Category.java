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

@Entity
@Table(name = "category", catalog = "mall")
public class Category extends BaseEntity {

	private static final long serialVersionUID = 7627569298980422618L;
	
	private String name;
	private String description;
	private Category category;
	private Set<Spec> specs = new HashSet<Spec>(0);
	private Set<Property> properties = new HashSet<Property>(0);
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Category> categories = new HashSet<Category>(0);

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Spec> getSpecs() {
		return this.specs;
	}

	public void setSpecs(Set<Spec> specs) {
		this.specs = specs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
