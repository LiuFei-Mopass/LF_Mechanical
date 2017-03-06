package maven;



import java.util.List;

import org.springframework.dao.support.DaoSupport;

import com.lf.reception.bean.RecNewsInfoObj;
import com.lf.reception.dao.RecNewsInfoDao;
import com.lf.reception.dao.impl.RecNewsInfoDaoImpl;

public class Test {
	
	
	
	
	public static void main(String[] args) throws Exception {
		RecNewsInfoDao rdao = new RecNewsInfoDaoImpl();
        List<RecNewsInfoObj> recNewsInfoAll = rdao.getRecNewsInfoAll();
        System.out.println(recNewsInfoAll.size());
    }

}
