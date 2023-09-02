package WebShop_Tricentis;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LoginTest extends ChromeDriver {

    By loginlink = By.xpath("//a[@href='/login']");
    By email = By.cssSelector("input[id='Email']");
    By password = By.cssSelector("input[id='Password']");
    By login = By.cssSelector("input[class='button-1 login-button']");


    @Test

    public void orderHistoryDownloaD() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement Login = driver.findElement(loginlink);
        Login.click();

        WebElement Email = driver.findElement(email);
        Email.sendKeys("senoldogan2018@gmail.com");

        WebElement Password = driver.findElement(password);
        Password.sendKeys("Senol1988++");

        WebElement LoginBtn = driver.findElement(login);
        LoginBtn.click();
        MyFunc.Bekle(1);

        BekleVeKapat();
    }

}
