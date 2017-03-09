package com.lf.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lf.bean.comm.PageObj;
import com.lf.util.string.StringUtil;

public class JDBCUtils {

	
	private static Logger log = Logger.getLogger("Mechanical-JDBC");
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 获取数据库连接
	* @return   Connection
	* @author LiuFei
	* @throws 
	*/
	public static Connection getConnection(){
		return DBConnection.getConnection();
	}
	
	

	/** 
	* @Title: Mechanical 
	* @Description: 公用查询方法
	* @param sql
	* @param parm
	* @return  
	* @author LiuFei
	* @throws 
	*/
	public static List<Map<String, String>> selectSqlForList_ps(String sql , Integer[] parm){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try {
			con = DBConnection.getConnection();
			log.info(" jdbc.execute 执行sql:"+sql+"  ");
			ps = con.prepareStatement(sql);
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
			DBConnection.close(rs, ps, null, con);
		}
		return list;
	}


	/** 
	* @Title: Mechanical 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param selectFeild
	* @param selectTabName
	* @param selectWhere
	* @param page
	* @param orderBy   key:orderby/desc
	* @return  
	* @author LiuFei
	* @2017年3月9日 上午11:45:44
	* @throws 
	*/
	public static List<Map<String, String>> selectCommList_ps(String selectFeild ,String selectTabName , Map<String , String> selectWhere 
			, PageObj page , Map<String , String> orderBy){
		
		if(StringUtil.isNotEmpty(selectFeild) && StringUtil.isNotEmpty(selectTabName)){
			throw new RuntimeException("参数为空!");
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ").append(selectFeild).append(" FROM ").append(StringUtil.CaseChandes(selectTabName));
		sql.append( " WHERE  1=1 ");
		if(null != selectWhere && selectWhere.size()>0){
			for (Map.Entry<String, String> map :selectWhere.entrySet() ) {
				if(map.getValue()==null || map.getValue().equals("null")){
					sql.append(" AND  " +map.getKey() + " is null ");
				}else{
					sql.append(" AND  " +map.getKey() + "=" + "'"+map.getValue()+"' ");
				}
			}
		}
		if(orderBy!=null && orderBy.size()>0){
			sql.append(" ORDER BY ").append(" "+orderBy.get("orderby")).append(" "+orderBy.get("desc"));
		}
		if(page!=null ){
			sql.append(" limit ").append(page.getPage()).append(page.getRows());
		}
		
		log.info(" JDBC-执行SQL: "+sql.toString()+"  ");
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql.toString());
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
			e.printStackTrace();
			log.error("  JDBC-执行SQL:："+e.getMessage()+"  ");
		}finally{
			DBConnection.close(rs, ps, null, con);
		}
		return list;
	}
	
	
	/** 
	* @Title: Mechanical 
	* @Description: insert方法
	* @param tabName
	* @param parms
	* @return  
	* @author LiuFei
	* @throws 
	*/
	public static int insert_s( String tabName , Map<String , String> parms){
		if(StringUtil.isNotEmpty(tabName) && parms.size()<1 ){
			throw new RuntimeException("参数为空!");
		}
		
		Connection con = null;
		Statement cs = null;
		ResultSet rs =null;
		String feild = "";
		String feildVal = "";
		int resultVal = 0;
		//
		for (Map.Entry<String, String> map : parms.entrySet()) {
			feild += ""+map.getKey()+",";
			feildVal += "'"+map.getValue()+"',";
		}
		//
		feild = feild.substring(0, feild.length()-1);
		feildVal = feildVal.substring(0, feildVal.length()-1);
		//
		String sql = " insert into "+ tabName +" ("+feild+")  values ("+feildVal+")";
		try {
			log.info("  JDBC-执行SQL: "+sql+"  ");
			con = DBConnection.getConnection();
			cs = con.createStatement();
			resultVal = cs.executeUpdate(sql);
		} catch (SQLException e) {
			log.error("  executeQuery 执行sql错误："+e.getMessage()+" ] ");
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultVal;
	}
	/** 
	* @Title: Mechanical 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param tabName
	* @param parms
	* @param con
	* @return  
	* @author LiuFei
	* @throws 
	*/
	public static int insert_s( String tabName , Map<String , String> parms , Connection con){
		if(StringUtil.isNotEmpty(tabName) && parms.size()<1 ){
			throw new RuntimeException("参数为空!");
		}
		Statement cs = null;
		ResultSet rs =null;
		String feild = "";
		String feildVal = "";
		int resultVal = 0;
		//
		for (Map.Entry<String, String> map : parms.entrySet()) {
			feild += ""+map.getKey()+",";
			feildVal += "'"+map.getValue()+"',";
		}
		//
		feild = feild.substring(0, feild.length()-1);
		feildVal = feildVal.substring(0, feildVal.length()-1);
		//
		String sql = " insert into "+ tabName +" ("+feild+")  values ("+feildVal+")";
		try {
			log.info("  JDBC-执行SQL: "+sql+"  ");
			cs = con.createStatement();
			resultVal = cs.executeUpdate(sql);
		} catch (SQLException e) {
			log.error(" [ executeQuery 执行sql错误："+e.getMessage()+" ] ");
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultVal;
	}
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 修改方法
	* @param tabName
	* @param parms
	* @param con
	* @return  
	* @author LiuFei
	* @throws 
	*/
	public static int update_s( String tabName , Map<String , String> parms ,  String sqlSelectWhere,Connection con){
		if(StringUtil.isNotEmpty(tabName) && parms.size()<1 ){
			throw new RuntimeException("参数为空!");
		}
		Statement cs = null;
		ResultSet rs =null;
		String updateFeild = "";
		int resultVal = 0;
		//
		for (Map.Entry<String, String> map : parms.entrySet()) {
			updateFeild += map.getKey()+"='"+map.getValue()+"',";
		}
		updateFeild = updateFeild.substring(0,updateFeild.length()-1);
		String sql = " update "+tabName+" set  "+updateFeild;
		try {
			log.info("  JDBC-执行SQL: "+sql+"  ");
			cs = con.createStatement();
			resultVal = cs.executeUpdate(sql);
		} catch (SQLException e) {
			log.error(" [ executeQuery 执行sql错误："+e.getMessage()+" ] ");
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultVal;
	}
	/** 
	* @Title: Mechanical 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param tabName 区分
	* @param parms
	* @param sqlSelectWhere
	* @return  
	* @author LiuFei
	* @throws 
	*/
	public static int update_s( String tabName , Map<String , String> parms ,  String sqlSelectWhere){
		if(StringUtil.isNotEmpty(tabName) && parms.size()<1 ){
			throw new RuntimeException("参数为空!");
		}
		Connection con = null;
		Statement cs = null;
		ResultSet rs =null;
		String updateFeild = "";
		int resultVal = 0;
		//
		for (Map.Entry<String, String> map : parms.entrySet()) {
			updateFeild += map.getKey()+"='"+map.getValue()+"',";
		}
		updateFeild = updateFeild.substring(0,updateFeild.length()-1);
		String sql = " update "+tabName+" set  "+updateFeild + " where "+sqlSelectWhere;
		try {
			log.info("  JDBC-执行SQL: "+sql+"  ");
			con = DBConnection.getConnection();
			cs = con.createStatement();
			resultVal = cs.executeUpdate(sql);
		} catch (SQLException e) {
			log.error(" [ executeQuery 执行sql错误："+e.getMessage()+" ] ");
		}finally{
			DBConnection.close(rs, null, cs, con);
		}
		return resultVal;
	}
	
	
	
	
	
	
	
	
	
	
}
