package WebShop_Tricentis;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NegativeLogin_03_ extends ChromeDriver {

    By loginlink = By.xpath("//a[@href='/login']");
    By email = By.cssSelector("input[id='Email']");
    By password = By.cssSelector("input[id='Password']");
    By login = By.cssSelector("input[class='button-1 login-button']");

    @Test
    public void test3() {

        //Bos Mail ve  gecerli Password girerek test etme
        driver.get("https://demowebshop.tricentis.com/login");

        WebElement Login = driver.findElement(By.xpath("//a[@href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.cssSelector("input[id='Email']"));
        Email.sendKeys("");

        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Password.sendKeys("Senol1988++");

        WebElement LoginBtn = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        LoginBtn.click();
        MyFunc.Bekle(1);

        WebElement error = driver.findElement(By.cssSelector("[class='validation-summary-errors']"));
        Assert.assertTrue(error.isDisplayed());

        BekleVeKapat();


    }
}




