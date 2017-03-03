package maven;

import java.util.HashMap;
import java.util.Map;

import com.lf.util.jdbc.JDBCUtils;

public class Test {
	
	public static void main(String[] args) throws Exception {
       
		
		Map<String , String> map = new HashMap<String , String>();
		
		
		map.put("user_name", "lf");
		map.put("user_password", "lf");
		
		String where = "user_id='3'";
		
		int insert = JDBCUtils.update_s("bac_user", map, where);
		System.out.println("====>"+insert);
		
    }

}
