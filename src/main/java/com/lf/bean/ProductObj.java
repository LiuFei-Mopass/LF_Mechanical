package com.lf.bean;


/** 
* @Title: Mechanical 
* @Description: TODO(这里用一句话描述这个方法的作用)   
* @author LiuFei
* @throws 
*/
public class ProductObj {
	
	private String seriald;
	private String productTypeNo; // 产品类别名称 
	private String productTypeName; // 产品类别名称  
	private String productTypeImg; // 产品类别图片  
	private String productNo;
	private String productName;
	private String productImg;
	private String reqUrl;
	private String markImg; //描述图片
	private String markDes; //描述文字
	private String isDelete; // 默认0    删除1
	
	
	
	
	
	public String getSeriald() {
		return seriald;
	}
	public void setSeriald(String seriald) {
		this.seriald = seriald;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getReqUrl() {
		return reqUrl;
	}
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	public String getMarkImg() {
		return markImg;
	}
	public void setMarkImg(String markImg) {
		this.markImg = markImg;
	}
	public String getMarkDes() {
		return markDes;
	}
	public void setMarkDes(String markDes) {
		this.markDes = markDes;
	}
	public String getProductTypeNo() {
		return productTypeNo;
	}
	public void setProductTypeNo(String productTypeNo) {
		this.productTypeNo = productTypeNo;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getProductTypeImg() {
		return productTypeImg;
	}
	public void setProductTypeImg(String productTypeImg) {
		this.productTypeImg = productTypeImg;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	

}
