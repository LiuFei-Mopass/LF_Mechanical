package com.lf.bean.comm;

/** 
* @Title: Mechanical 
* @Description: 分页
* @author LiuFei
* @2017年3月9日 上午11:39:35
* @throws 
*/
public class PageObj {

	
	private int page;
	private int rows;
	
	public PageObj() {
		super();
	}
	public PageObj(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
	
	
}
