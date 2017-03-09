package com.lf.controller.backstage;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lf.bean.comm.DataGrid;
import com.lf.bean.comm.PageObj;
import com.lf.bean.comm.SysEnumsObj;
import com.lf.dao.comm.SysEnumsDao;
import com.lf.dao.comm.impl.SysEnumsDaoImpl;

@Controller
public class EnumsController {
	
	Logger log = Logger.getLogger("Mechanical-Controller");
	
	private SysEnumsDao enumDao = new SysEnumsDaoImpl();
	
	@ResponseBody
	@RequestMapping(value="/getEnumsAll.html" , method=RequestMethod.POST)
	public DataGrid getEnumsAll(Integer page,Integer rows){
		
		System.out.println("00000000000000000000000000000000");
		System.out.println("00000000000000000000000000000000");
		System.out.println("00000000000000000000000000000000");
		System.out.println("00000000000000000000000000000000");
		System.out.println("00000000000000000000000000000000");
		System.out.println("00000000000000000000000000000000");
		System.out.println("00000000000000000000000000000000");
		
		DataGrid dg = new DataGrid();
		
		
		List<SysEnumsObj> selectSysEnumsAll = enumDao.selectSysEnumsAll();
		
		
		
		dg.setTotal("5");
		dg.setRows(selectSysEnumsAll);
		return dg;
	}
	
	@RequestMapping(value="/getParEnumsList.html")
	public DataGrid getParEnumsList(Integer page,Integer rows) throws Exception{
		DataGrid dg = new DataGrid();
		if(page!=null && rows!=null ){
			throw new Exception("参数不能为空!");
		}
		
		PageObj pageobj = new PageObj();
		if(page==0){
			pageobj.setPage(page);
		}else{
			pageobj.setPage((page-1)*rows);
		}
		pageobj.setRows(rows);
		
		List<SysEnumsObj> parEnumsList = enumDao.getParEnumsList(pageobj);
		
		dg.setRows(parEnumsList);
		dg.setTotal(String.valueOf(parEnumsList.size()));
		return dg;
	}
	
	/*	DataGrid datagrid = new DataGrid();
	public DataGrid getEnums(Integer page,Integer rows){
		Util utils = new Util();
		if(page==0){
			utils.setInteger1(page);
		}else{
		utils.setInteger1((page-1)*rows);
		}
		utils.setInteger2(rows);
		log.info("======开始分页查询枚举值 page:"+utils.getInteger1()+"=====");
		List<EnumsParent> findAllBackEnums = enumservice.getEnumsParentList(utils);
		datagrid.setTotal(enumservice.getEnumsSize().toString());
		datagrid.setRows(findAllBackEnums);
		log.info("======开始分页查询枚举值 结束=====");
		return datagrid;
	}*/
	
	
	
	

}
