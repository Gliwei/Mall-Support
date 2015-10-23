package com.lw.core.util;

import java.util.List;

public class Pageable<T> {
	// 每页行数
	private int rows;
	// 当前页
	private int page;
	// 总记录数
	private int count;
	// 总页数
	private int pages;
	// 开始行
	private int startRow;
	// 行列表
	private List<T> list;
	
	@SuppressWarnings("unused")
	private Pageable() {}
	
	public Pageable(int page) {
		this(page, 15);
	}
	
	public Pageable(int page, int rows) {
		this.page = page;
		this.rows = rows;
		
		this.startRow = (page-1)*rows;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		this.setPages(count/this.getRows());
	}
	
}
