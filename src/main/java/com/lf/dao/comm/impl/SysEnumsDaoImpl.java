package com.lf.dao.comm.impl;

import java.util.List;
import java.util.Map;

import com.lf.bean.comm.SysEnumsObj;
import com.lf.dao.comm.SysEnumsDao;
import com.lf.util.jdbc.JDBCUtils;

/** 
* @Title: Mechanical 
* @Description: TODO(这里用一句话描述这个方法的作用)   
* @author LiuFei
* @2017年3月7日 下午8:17:30
* @throws 
*/
public class SysEnumsDaoImpl implements SysEnumsDao {
	
	
	String selectFeild = "sys_id,sys_key,sys_value,sys_desc,sys_key1,sysv_alue1,sys_desc1,sys_sequ,is_delete";
	
	
	public SysEnumsObj mapToObj(Map<String, String> parMap){
		
		String[] split = selectFeild.split(",");
		for (int i = 0; i < split.length; i++) {
			
			
			String[] split2 = split[i].split("_");
			String feild = split2[1];
			
			
			//feild = feild.charAt(0).t
			
			
			
			
		}
		return null;
		
		
		
		
		
	}
	
	
	

	@Override
	public List<SysEnumsObj> selectSysEnumsList(String sysKey) {
		// TODO Auto-generated method stub
		
		List<Map<String, String>> selectCommList_ps = JDBCUtils.selectCommList_ps(selectFeild, "", "");
		
		
		
		
		return null;
	}

	@Override
	public SysEnumsObj selectSysEnums(String sysKey) {
		// TODO Auto-generated method stub
		return null;
	}

}
