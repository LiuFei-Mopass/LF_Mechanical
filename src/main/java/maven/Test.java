package maven;

import org.apache.log4j.Logger;

public class Test {
	
	public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger("Mechanical");
        logger.info("开始");
        logger.debug("结束");
    }

}
