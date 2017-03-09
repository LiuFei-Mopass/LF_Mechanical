package com.lf.bean.comm;

import java.util.List;

/**
 * 方法描述-datagrid to json bean
 * @author  LIUFEI
 * @date  2016-6-21
 */
public class DataGrid {
	private String total;
	private List rows;
	
	
	public DataGrid() {
		super();
	}
	public DataGrid(String total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	} 
	

}
