package WebShop_Tricentis;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OrderHistoryDownload extends ChromeDriver {


    By account = By.cssSelector("a[class='account']");
    By orders = By.xpath("//a[@href='/customer/orders']");
    By details = By.cssSelector("input[class='button-2 order-details-button']");
    By pdfFile = By.cssSelector("[class='button-2 pdf-order-button']");


    @Test

    public void orderHistoryDownloaD() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement Login = driver.findElement(By.xpath("//a[@href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.cssSelector("input[id='Email']"));
        Email.sendKeys("senoldogan2018@gmail.com");

        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Password.sendKeys("Senol1988++");

        WebElement LoginBtn = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        LoginBtn.click();
        MyFunc.Bekle(1);

        WebElement Account = driver.findElement(account);
        Account.click();
        MyFunc.Bekle(1);

        WebElement Orders = driver.findElement(orders);
        Orders.click();
        MyFunc.Bekle(1);


        MyFunc.Bekle(1);

        WebElement Details = driver.findElement(details);
        Details.click();
        MyFunc.Bekle(1);

        WebElement Pdf = driver.findElement(pdfFile);
        Pdf.click();
        MyFunc.Bekle(1);

        Robot robot = new Robot();

        for (int i = 0; i < 26; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
        }
        MyFunc.Bekle(2);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        MyFunc.Bekle(2);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        MyFunc.Bekle(1);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_W);
        MyFunc.Bekle(1);

        BekleVeKapat();

    }
}
