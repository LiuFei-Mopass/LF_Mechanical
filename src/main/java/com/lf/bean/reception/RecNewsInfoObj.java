package com.lf.bean.reception;

/** 
* @Title: Mechanical 
* @Description: 新闻资讯   
* @author LiuFei
* @throws 
*/
public class RecNewsInfoObj {

	private String serialId;
	private String newsTitle;
	private String newsContent;
	private String newsAuother;
	private String clickNum ;
	private String createTime;
	private String updateTime ;
	private String isDelete; // '0-有效数据，1-无效数据'
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
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
	public String getNewsAuother() {
		return newsAuother;
	}
	public void setNewsAuother(String newsAuother) {
		this.newsAuother = newsAuother;
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
