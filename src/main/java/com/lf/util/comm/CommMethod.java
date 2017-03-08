package com.lf.util.comm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class CommMethod {

	
	/** 
	* @Title: Mechanical 
	* @Description: 反射将map中的值赋值给对象
	* @param object
	* @param parMap  
	* @author LiuFei
	* @2017年3月8日 下午6:24:48
	* @throws 
	*/
	public static void setFeildValue(Object object , Map<String , String> parMap){
		try {
			Class<? extends Object> cls = object.getClass();
			//Method[] methods = cls.getDeclaredMethods();  
	        Field[] fields = cls.getDeclaredFields();
	        
	        for (Field field : fields) {
	        	for (Map.Entry<String, String> map : parMap.entrySet()) {
		        	if(map.getKey().equals(field.getName())){
		        		String parSetName = CommMethod.firstCaseToSet(field.getName());
						Method fieldSetMet = cls.getMethod(parSetName, field.getType());
						fieldSetMet.invoke(object, map.getValue());
		        	}
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	/** 
	* @Title: Mechanical 
	* @Description: 将数据Map转Object 
	* @param object
	* @param parMap  
	* @author LiuFei
	* @2017年3月8日 下午7:58:06
	* @throws 
	*/
	public static void mapToObjectDB(Object object , Map<String , String> parMap){
		try {
			Class<? extends Object> cls = object.getClass();
			//Method[] methods = cls.getDeclaredMethods();  
	        Field[] fields = cls.getDeclaredFields();
	        
	        for (Field field : fields) {
	        	for (Map.Entry<String, String> map : parMap.entrySet()) {
	        		String keyName = CommMethod.feildRule(map.getKey());
	        		if(keyName.equals(field.getName())){
		        		String parSetName = CommMethod.firstCaseToSet(field.getName());
						Method fieldSetMet = cls.getMethod(parSetName, String.class);
						fieldSetMet.invoke(object, map.getValue());
		        	}
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/** 
	* @Title: Mechanical 
	* @Description: 首字母大写
	* @param fieldName
	* @return  
	* @author LiuFei
	* @2017年3月8日 下午6:27:42
	* @throws 
	*/
	private static String firstCase(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    }
	
	private static String firstCaseToSet(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return "set" + fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    }
	
	
	/** 
	* @Title: Mechanical 
	* @Description: 将sys_id 转换成 sysId
	* @param fileName
	* @return  
	* @author LiuFei
	* @2017年3月8日 下午6:31:38
	* @throws 
	*/
	public static String feildRule(String fileName ){
		
		String result = "";
		if(fileName.contains("_")){
			String[] split = fileName.split("_");
			result = split[0];
			for (int i = 0; i < split.length; i++) {
				if(i!=0){
					result += CommMethod.firstCase(split[i]);
				}
			}
		}
		return result;
	}
	
	
	
	//public static String
	/** 
	* @Title: Mechanical 
	* @Description: 将对象字段 转成 sql查询字段
	* @param object
	* @return  
	* @author LiuFei
	* @2017年3月8日 下午7:39:30
	* @throws 
	*/
	public static String ObjectFeildToString(Object object){
		Field[] declaredFields = object.getClass().getDeclaredFields();
		String strArr = "";
		for (int j = 0; j < declaredFields.length; j++) {
			Field field = declaredFields[j];
			String strName = field.getName();
			String str = "";
			for (int i = 0; i < strName.length(); i++) {
				char charStr = strName.charAt(i);
				if(Character.isUpperCase(charStr)){
					str +="_"+(String.valueOf(charStr)).toLowerCase();
				}else{
					str += charStr;
				}
			}
			if(j!=0){
				strArr +=",";
			}
			strArr +=str;
		}
		return strArr;
	}
	
	
}
