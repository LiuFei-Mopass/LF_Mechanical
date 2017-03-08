package com.lf.dao.comm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	
	SysEnumsObj  FeildObj= new SysEnumsObj();
	
	
	String selectFeild = "sys_id,sys_key,sys_value,sys_desc,sys_key1,sysv_alue1,sys_desc1,sys_sequ,is_delete";
	
	public SysEnumsDaoImpl(){
		selectFeild = CommMethod.ObjectFeildToString(FeildObj);
	}
	

	@Override
	public List<SysEnumsObj> selectSysEnumsList(String sysKey) {
		// TODO Auto-generated method stub
		List<SysEnumsObj>  enumsList = new ArrayList<SysEnumsObj>();
		List<Map<String, String>> selectCommList = JDBCUtils.selectCommList_ps(selectFeild, "lf_sysenums", "");
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


	@Override
	public List<SysEnumsObj> selectSysEnumsAll() {
		// TODO Auto-generated method stub
		List<SysEnumsObj>  enumsList = new ArrayList<SysEnumsObj>();
		List<Map<String, String>> selectCommList = JDBCUtils.selectCommList_ps(selectFeild, "lf_sysenums", "");
		for (Map<String, String> map : selectCommList) {
			SysEnumsObj  enumsObj= new SysEnumsObj();
			CommMethod.mapToObjectDB(enumsObj, map);
			enumsList.add(enumsObj);
		}
		return enumsList;
	}

}
