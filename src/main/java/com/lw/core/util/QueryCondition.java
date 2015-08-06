package com.lw.core.util;

public class QueryCondition {
	
	private StringBuilder sql = new StringBuilder();
	
	/**
	 * 属性名
	 */
	private String propertyName;
	
	/**
	 * 运算符 > < <= >= != ...
	 */
	private Operator operator;
	
	/**
	 * 属性值
	 */
	private String propertyValue;
	
	public String getSql(){
		return sql.toString();
	}
	
	public QueryCondition and(QueryCondition query){
		sql.append(" AND ").append("(").append(query.toString()).append(")");
		return this;
	}
	
	public QueryCondition and(String propertyName, Operator operator, String propertyValue){
		QueryCondition query = new QueryCondition(propertyName, operator, propertyValue);
		sql.append(" AND ").append("(").append(query.toString()).append(")");
		return this;
	}
	
	public QueryCondition or(QueryCondition query){
		sql.append(" OR ").append("(").append(query.toString()).append(")");
		return this;
	}
	
	public QueryCondition or(String propertyName, Operator operator, String propertyValue){
		QueryCondition query = new QueryCondition(propertyName, operator, propertyValue);
		sql.append(" OR ").append("(").append(query.toString()).append(")");
		return this;
	}

	private void appendSql(QueryCondition query, String AO){
		if(sql.length() != 0){
			sql.append(AO);
		}
		sql.append(" ");
		sql.append(query.getPropertyName());
		sql.append(" ");
		
		sql.append(query.getOperator().code());
		sql.append(" ");
		if(query.getOperator().equals(Operator.LIKE)){
			sql.append("'%"+query.getPropertyValue()+"%'");
		}else{
			sql.append(query.getPropertyValue());
		}
		sql.append(" ");
	}

	public QueryCondition(String propertyName, Operator operator, String propertyValue) {
		super();
		this.propertyName = propertyName;
		this.operator = operator;
		this.propertyValue = propertyValue;
		
		this.appendSql(this, "");
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public String toString() {
		return this.getSql();
	}
}
