package com.lf.dao.comm;

import java.util.List;

import com.lf.bean.comm.CommObj;
import com.lf.bean.comm.PageObj;
import com.lf.bean.comm.SysEnumsObj;

/** 
* @Title: Mechanical 
* @Description: 系统参数DAO层  
* @author LiuFei
* @2017年3月7日 下午8:16:41
* @throws 
*/
public interface SysEnumsDao {

	/** 
	* @Title: Mechanical 
	* @Description: 查询枚举值集合
	* @param sysKey
	* @return  
	* @author LiuFei
	* @2017年3月7日 下午8:34:52
	* @throws 
	*/
	public List<SysEnumsObj> selectSysEnumsList(String sysKey);
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 查找非父子关联枚举值
	* @return  
	* @author LiuFei
	* @2017年3月9日 上午10:19:24
	* @throws 
	*/
	public List<SysEnumsObj> selectSysEnumsAll();
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 查询枚举值对象
	* @param sysKey
	* @return  
	* @author LiuFei
	* @2017年3月7日 下午8:35:32
	* @throws 
	*/
	public SysEnumsObj selectSysEnums(String sysKey);
	
	
	
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 添加枚举值
	* @param enumsObj
	* @return  
	* @author LiuFei
	* @2017年3月8日 下午7:41:08
	* @throws 
	*/
	public int insert(SysEnumsObj enumsObj);
	
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 查找父类枚举值
	* @param commobj
	* @return  
	* @author LiuFei
	* @2017年3月9日 上午10:18:29
	* @throws 
	*/
	public List<SysEnumsObj> getParEnumsList(PageObj pageobj);
	
	/** 
	* @Title: Mechanical 
	* @Description: 查找子类枚举值
	* @param commobj
	* @return  
	* @author LiuFei
	* @2017年3月9日 上午10:18:45
	* @throws 
	*/
	public List<SysEnumsObj> getChildEnumsList(CommObj commobj);
	
	
	
	
}
