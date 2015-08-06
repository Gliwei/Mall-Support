package com.lw.core.util;

public class QueryHandler{
	
	public static QueryCondition query(String propertyName, Operator operator, String propertyValue){
		return new QueryCondition(propertyName, operator, propertyValue);
	}
}
