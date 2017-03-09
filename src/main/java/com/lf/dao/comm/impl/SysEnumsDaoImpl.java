package com.lf.dao.comm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lf.bean.comm.CommObj;
import com.lf.bean.comm.PageObj;
import com.lf.bean.comm.SysEnumsObj;
import com.lf.dao.comm.SysEnumsDao;
import com.lf.util.comm.CommMethod;
import com.lf.util.jdbc.JDBCUtils;

/** 
* @Title: Mechanical 
* @Description: TODO(这里用一句话描述这个方法的作用)   
* @author LiuFei
* @2017年3月7日 下午8:17:30
* @throws 
*/
public class SysEnumsDaoImpl implements SysEnumsDao {
	
	Logger log = Logger.getLogger("Mechanical-DaoImpl");
	SysEnumsObj  FeildObj= new SysEnumsObj();
	
	
	String selectFeild = "sys_id,sys_key,sys_value,sys_desc,sys_key1,sysv_alue1,sys_desc1,sys_sequ,is_delete";
	
	public SysEnumsDaoImpl(){
		selectFeild = CommMethod.ObjectFeildToString(FeildObj);
	}
	

	@Override
	public List<SysEnumsObj> selectSysEnumsList(String sysKey) {
		// TODO Auto-generated method stub
		List<SysEnumsObj>  enumsList = new ArrayList<SysEnumsObj>();
		List<Map<String, String>> selectCommList = JDBCUtils.selectCommList_ps(selectFeild, "lf_sysenums", null , null , null);
		for (Map<String, String> map : selectCommList) {
			SysEnumsObj  enumsObj= new SysEnumsObj();
			CommMethod.mapToObjectDB(enumsObj, map);
			enumsList.add(enumsObj);
		}
		return enumsList;
	}

	@Override
	public SysEnumsObj selectSysEnums(String sysKey) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public int insert(SysEnumsObj enumsObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/** 
	* @Title: Mechanical 
	* @Description: 查找非父子关联枚举值
	* @return  
	* @author LiuFei
	* @2017年3月9日 上午10:19:24
	* @throws 
	*/
	@Override
	public List<SysEnumsObj> selectSysEnumsAll() {
		List<SysEnumsObj>  enumsList = new ArrayList<SysEnumsObj>();
		List<Map<String, String>> selectCommList = JDBCUtils.selectCommList_ps(selectFeild, "lf_sysenums", null, null, null);
		for (Map<String, String> map : selectCommList) {
			SysEnumsObj  enumsObj= new SysEnumsObj();
			CommMethod.mapToObjectDB(enumsObj, map);
			enumsList.add(enumsObj);
		}
		return enumsList;
	}


	/** 
	* @Title: Mechanical 
	* @Description: 查找父类枚举值 
	* @param @param commobj
	* @param @return  
	* @author LiuFei
	* @throws 
	*/
	@Override
	public List<SysEnumsObj> getParEnumsList(PageObj pageobj) {
		List<SysEnumsObj>  enumsList = new ArrayList<SysEnumsObj>();
		try {
			Map<String , String> selectWhereMap = new HashMap<String , String>();
			selectWhereMap.put("sys_parent_no", null);
			selectWhereMap.put("is_delete", "0");
			Map<String , String> orderBy = new HashMap<String , String>();
			orderBy.put("orderby", "update_time");
			orderBy.put("desc", "desc");
			List<Map<String, String>> selectCommList = JDBCUtils.selectCommList_ps(selectFeild, "lf_sysenums", selectWhereMap ,pageobj ,orderBy);
			for (Map<String, String> map : selectCommList) {
				SysEnumsObj  enumsObj= new SysEnumsObj();
				CommMethod.mapToObjectDB(enumsObj, map);
				enumsList.add(enumsObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("====>获取父类枚举值异常："+e.getMessage());
		}
		return enumsList;
	}

	/** 
	* @Title: Mechanical 
	* @Description: 查找子类枚举值 
	* @param @param commobj
	* @param @return  
	* @author LiuFei
	* @throws 
	*/
	@Override
	public List<SysEnumsObj> getChildEnumsList(CommObj commobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
