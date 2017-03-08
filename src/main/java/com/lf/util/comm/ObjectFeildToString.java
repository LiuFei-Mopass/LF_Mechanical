package com.lf.util.comm;

import java.lang.reflect.Field;

public class ObjectFeildToString {

	
	public String newsObjString = "";
	
	
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
