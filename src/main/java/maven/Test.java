package maven;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lf.bean.comm.SysEnumsObj;
import com.lf.bean.reception.RecNewsInfoObj;
import com.lf.dao.comm.SysEnumsDao;
import com.lf.dao.comm.impl.SysEnumsDaoImpl;
import com.lf.dao.reception.RecNewsInfoDao;
import com.lf.dao.reception.impl.RecNewsInfoDaoImpl;




public class Test {
	
	
	static RecNewsInfoDao newsDao = new RecNewsInfoDaoImpl();
	static SysEnumsDao enumDao = new SysEnumsDaoImpl();
	
	public static void main(String[] args) throws Exception {
//		RecNewsInfoDao rdao = new RecNewsInfoDaoImpl();
//        List<RecNewsInfoObj> recNewsInfoAll = rdao.getRecNewsInfoAll();
//        System.out.println(recNewsInfoAll.size());
		
		
		
//        Map<String, String> valMap = new HashMap<String, String>();  
//
//        List<RecNewsInfoObj> recNewsInfoAll = newsDao.getRecNewsInfoAll();
//        for (RecNewsInfoObj recNewsInfoObj : recNewsInfoAll) {
//			System.out.println(recNewsInfoObj.getSerialId());
//		}
		
		
		List<SysEnumsObj> selectSysEnumsAll = enumDao.selectSysEnumsAll();
		System.out.println(selectSysEnumsAll.size());
		
    }
 
	
    private static String parSetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        return "set" + fieldName.substring(0, 1).toUpperCase()  
                + fieldName.substring(1);  
    } 
    private static boolean checkSetMet(Method[] methods, String fieldSetMet) {  
        for (Method met : methods) {  
            if (fieldSetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    } 

}
