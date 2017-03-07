package maven;



import java.util.List;

import org.springframework.dao.support.DaoSupport;

import com.lf.bean.reception.RecNewsInfoObj;
import com.lf.dao.reception.RecNewsInfoDao;
import com.lf.dao.reception.impl.RecNewsInfoDaoImpl;

public class Test {
	
	
	
	
	public static void main(String[] args) throws Exception {
		RecNewsInfoDao rdao = new RecNewsInfoDaoImpl();
        List<RecNewsInfoObj> recNewsInfoAll = rdao.getRecNewsInfoAll();
        System.out.println(recNewsInfoAll.size());
    }

}
