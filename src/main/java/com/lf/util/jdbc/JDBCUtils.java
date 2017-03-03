package com.lf.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class JDBCUtils {

	
	private static DBConnection cons = new DBConnection();
	private static Logger log = Logger.getLogger("Mechanical-JDBC");
	
	

	/** 
	* @Title: Mechanical 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param sql
	* @param parm
	* @return  
	* @author LiuFei
	* @throws 
	*/
	public static List<Map<String, String>> exeSqlForList(String sql , Integer[] parm){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try {
			con = cons.getConnection();
			log.info("[ jdbc.execute 执行sql:"+sql+"  ]");
			ps = con.prepareStatement(sql.toLowerCase());
			if(parm!=null){
				for (int i = 0; i < parm.length; i++) {
					ps.setObject(i+1, parm[i]);
				}
			}
			rs = ps.executeQuery();
		    ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
		    int columnCount = md.getColumnCount();   //获得列数 
	        while(rs.next()){
	        	Map<String,String> rowData = new HashMap<String,String>();
	        	for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rs.getString(i));
	            }
	        	list.add(rowData);
	        }
		} catch (SQLException e) {
			log.error(" [ executeQuery 执行sql错误："+e.getMessage()+" ] ");
		}finally{
			cons.close(rs, ps, con);
		}
		return list;
	}
	
	
	
	
}
