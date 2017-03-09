package com.lf.dao.reception.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lf.bean.reception.RecNewsInfoObj;
import com.lf.dao.reception.RecNewsInfoDao;
import com.lf.util.comm.CommMethod;
import com.lf.util.jdbc.JDBCUtils;
import com.lf.util.string.StringUtil;

public class RecNewsInfoDaoImpl implements RecNewsInfoDao {
	
	
	 Logger log = Logger.getLogger("Mechanical");
	private String selectFeild = "seriald,news_title,news_content,news_auother,click_num,create_time,update_time,is_delete";
	

	
	/** 
	* @Title: Mechanical 
	* @Description: 将map转为obj 针对实体对象
	* @param parms
	* @return  
	* @author LiuFei
	* @2017年3月6日 下午5:38:35
	* @throws 
	*/
//	public RecNewsInfoObj mapToObj(Map<String, String> parms){
//		RecNewsInfoObj recNewsInfo= new RecNewsInfoObj();
//		try {
//			//StringUtil.KillNull(parms.get("seriald"))
//			recNewsInfo.setSeriald(StringUtil.KillNull(parms.get("seriald")));
//			recNewsInfo.setNewsTitle(StringUtil.KillNull(parms.get("news_title")));
//			recNewsInfo.setNewsContent(StringUtil.KillNull(parms.get("news_content")));
//			recNewsInfo.setNewAuother(StringUtil.KillNull(parms.get("news_auother"))); 
//			recNewsInfo.setNewsContent(StringUtil.KillNull(parms.get("click_num"))); 
//			recNewsInfo.setCreateTime(StringUtil.KillNull(parms.get("create_time"))); 
//			recNewsInfo.setUpdateTime(StringUtil.KillNull(parms.get("update_time"))); 
//			recNewsInfo.setIsDelete(StringUtil.KillNull(parms.get("is_delete"))); 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(" mapToObj异常: "+e.getMessage());
//		}
//		return recNewsInfo;
//	}
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 添加数据
	* @param @param recNewsInfo
	* @param @return  
	* @author LiuFei
	* @throws 
	*/
	@Override
	public int insertData(RecNewsInfoObj recNewsInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/** 
	* @Title: Mechanical 
	* @Description: 查询所有数据
	* @param @return  
	* @author LiuFei
	* @throws 
	*/
	@Override
	public List<RecNewsInfoObj> getRecNewsInfoAll() {
		
		List<RecNewsInfoObj>  recNewsInfoList = new ArrayList<RecNewsInfoObj>();
//		String tabName = "lf_news";
		String tabName = "lf_news";
		RecNewsInfoObj newsInfo=new RecNewsInfoObj();
		selectFeild = CommMethod.ObjectFeildToString(newsInfo);
		
		try {
			List<Map<String, String>> selectCommList = JDBCUtils.selectCommList_ps(selectFeild, tabName, null, null, null);
			for (int i = 0; i < selectCommList.size(); i++) {
				RecNewsInfoObj recNewsInfo = new RecNewsInfoObj();
				CommMethod.mapToObjectDB(recNewsInfo, selectCommList.get(i));
				recNewsInfoList.add(recNewsInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(" 查询表："+tabName+ " 异常: "+e.getMessage());
		}
		return recNewsInfoList;
	}

	/** 
	* @Title: Mechanical 
	* @Description: 查询具体数据
	* @param @param seriald
	* @param @return  
	* @author LiuFei
	* @throws 
	*/
	@Override
	public RecNewsInfoObj getRecNewsInfoById(String seriald) {
		// TODO Auto-generated method stub
		return null;
	}

}
