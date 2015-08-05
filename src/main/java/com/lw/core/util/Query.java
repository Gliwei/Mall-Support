package com.lw.core.util;

public class Query {
	
	/**
	 * 属性名
	 */
	private String propertyName;
	
	/**
	 * 运算符 > < <= >= != ...
	 */
	private String operator;
	
	/**
	 * 属性值
	 */
	private String propertyValue;

	public Query(String propertyName, String operator, String propertyValue) {
		super();
		this.propertyName = propertyName;
		this.operator = operator;
		this.propertyValue = propertyValue;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
}
