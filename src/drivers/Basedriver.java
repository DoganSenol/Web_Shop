package drivers;

import java.util.logging.Level;
import java.util.logging.Logger;

import static drivers.ChromeDriver.driver;

public class Basedriver {

    public static Logger logger;

    static {
        logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
    }

    public static void BekleVeKapat(){
        MyFunc.Bekle(5);
        driver.quit();
    }

}

