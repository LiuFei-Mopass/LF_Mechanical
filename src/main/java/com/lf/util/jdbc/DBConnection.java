package com.lf.util.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	   private static final Integer DBTYPE = 0;//0- 本地数据库 1-服务器数据库
	
		
		private static  String	DRIVER="com.mysql.jdbc.Driver";;
		private static  String	URL;
		private static  String	USERNAME;
		private static  String	PASSWORD;
		
		static{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public static Connection getConnection(){
			
			if(1==DBTYPE){
				URL="jdbc:mysql://192.168.1.74:49056/ea1e45316b9f4?useUnicode=true&characterEncoding=UTF-8";
				USERNAME="15ddbe186c144";
				PASSWORD="2095a6466b3b4";
			}else{
				URL="jdbc:mysql://localhost/Mechanical?useUnicode=true&characterEncoding=UTF-8";
				USERNAME="root";
				PASSWORD="admin";
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			return con;
		}
		public static void close(ResultSet rs ,PreparedStatement ps , Statement s  ,  Connection con){
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
				if(s!=null){
					s.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
