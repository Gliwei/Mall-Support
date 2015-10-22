package com.lw.core.util;


public class TEST {

	public static void main(String[] args) {
		// TEST.test2();
	}
	
	/*public static void test2(){
		Commodity c = new Commodity();
		c.setTitle("iMac");
		c.setCostPrice(new BigDecimal(300));
		QueryCondition q1 = new QueryCondition("title", Operator.LIKE, c.getTitle());
		QueryCondition q2 = new QueryCondition("costPrice", Operator.LT, c.getCostPrice().toString());
		//QueryCondition q3 = new QueryCondition("color", Operator.EQ, "深空灰");
		//QueryCondition q4 = new QueryCondition("height", Operator.EQ, "200");
		
		
		BaseDao<Commodity, Integer> bd = new BaseDao<Commodity, Integer>(Commodity.class);
		bd.findByPage(null, q1.and(q2));
	}*/
	
	public static void test1(){
		QueryCondition q1 = new QueryCondition("title", Operator.LIKE, "iPhone");
		QueryCondition q2 = new QueryCondition("price", Operator.LT, "4800");
		QueryCondition q3 = new QueryCondition("color", Operator.EQ, "深空灰");
		QueryCondition q4 = new QueryCondition("height", Operator.EQ, "200");
		
		QueryHandler qh = new QueryHandler();
		
		System.out.println(q1.or(q2.and(q3.or(q4))));
		
		String sql = QueryHandler.query("title", Operator.LIKE, "iPhone").and("price", Operator.LT, "4800").getSql();
		System.out.println(sql);
	}

}
