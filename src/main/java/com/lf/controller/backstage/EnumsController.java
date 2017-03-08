package com.lf.controller.backstage;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lf.bean.comm.DataGrid;
import com.lf.bean.comm.SysEnumsObj;
import com.lf.dao.comm.SysEnumsDao;
import com.lf.dao.comm.impl.SysEnumsDaoImpl;

@Controller
public class EnumsController {
	
	Logger log = Logger.getLogger("Mechanical-Controller");
	
	private SysEnumsDao enumDao = new SysEnumsDaoImpl();
	
	@ResponseBody
	@RequestMapping(value="/getEnumsAll.html")
	public DataGrid getEnumsAll(){
		DataGrid dg = new DataGrid();
		
		
		List<SysEnumsObj> selectSysEnumsAll = enumDao.selectSysEnumsAll();
		
		
		
		dg.setTotal("5");
		dg.setRows(selectSysEnumsAll);
		
		return dg;
		
		
	}
	
	
	
	

}
