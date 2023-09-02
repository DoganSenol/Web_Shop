package WebShop_Tricentis;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NegativeLogin_02_ extends ChromeDriver {



    @Test
    public void test3() {

        //Gecerli Mail ve bos Password girerek test etme
        driver.get("https://demowebshop.tricentis.com/login");

        WebElement Login = driver.findElement(By.xpath("//a[@href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.cssSelector("input[id='Email']"));
        Email.sendKeys("senoldogan2018@gmail.com");

        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Password.sendKeys("");

        WebElement LoginBtn = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        LoginBtn.click();
        MyFunc.Bekle(1);
        WebElement error = driver.findElement(By.cssSelector("[class='validation-summary-errors']"));
        Assert.assertTrue(error.isDisplayed());

        BekleVeKapat();


    }
}


