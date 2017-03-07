package com.lf.dao.reception;

import java.util.List;

import com.lf.bean.reception.RecNewsInfoObj;

/** 
* @Title: Mechanical 
* @Description:  前台新闻资讯DAO层
* @author LiuFei
* @2017年3月6日 下午4:48:52
* @throws 
*/
public interface RecNewsInfoDao {
	
	/** 
	* @Title: Mechanical 
	* @Description: 添加新闻数据
	* @param recNewsInfo
	* @return  
	* @author LiuFei
	* @2017年3月6日 下午4:50:23
	* @throws 
	*/
	public int insertData(RecNewsInfoObj recNewsInfo);
	
	/** 
	* @Title: Mechanical 
	* @Description:查询所有数据 
	* @return  
	* @author LiuFei
	* @2017年3月6日 下午4:51:18
	* @throws 
	*/
	public List<RecNewsInfoObj> getRecNewsInfoAll();
	
	/** 
	* @Title: Mechanical 
	* @Description: 查询具体一条数据
	* @param seriald
	* @return  
	* @author LiuFei
	* @2017年3月6日 下午4:53:19
	* @throws 
	*/
	public RecNewsInfoObj getRecNewsInfoById(String seriald);
	

}
