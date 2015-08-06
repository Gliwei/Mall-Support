package com.lw.core.util;

public enum Operator {
	EQ {public String code(){return "=";}},
	
	GT {public  String code(){return ">";}},
	
	LT {public String code(){return "<";}},
	
	GTEQ {public String code(){return ">=";}},
	
	LTEQ {public String code(){return "<=";}},
	
	LIKE {public  String code(){return "like";}},
	
	AND {public String code(){return "and";}},
	
	OR {public String code(){return "or";}};
	
	public abstract String code();
}