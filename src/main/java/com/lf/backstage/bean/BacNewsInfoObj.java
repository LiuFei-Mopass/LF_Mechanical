package com.lf.backstage.bean;

/** 
* @Title: Mechanical 
* @Description: TODO(这里用一句话描述这个方法的作用)   
* @author LiuFei
* @2017年3月6日 下午4:25:17
* @throws 
*/
public class BacNewsInfoObj {
	
	private String seriald;
	private String newsTitle;
	private String newsContent;
	private String newAuother;
	private String clickNum ;
	private String createTime;
	private String updateTime ;
	private String isDelete; // '0-有效数据，1-无效数据'
	
	
	public BacNewsInfoObj() {
		super();
	}
	public BacNewsInfoObj(String seriald, String newsTitle, String newsContent,
			String newAuother, String clickNum, String createTime,
			String updateTime, String isDelete) {
		super();
		this.seriald = seriald;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newAuother = newAuother;
		this.clickNum = clickNum;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
	}
	public String getSeriald() {
		return seriald;
	}
	public void setSeriald(String seriald) {
		this.seriald = seriald;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewAuother() {
		return newAuother;
	}
	public void setNewAuother(String newAuother) {
		this.newAuother = newAuother;
	}
	public String getClickNum() {
		return clickNum;
	}
	public void setClickNum(String clickNum) {
		this.clickNum = clickNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
