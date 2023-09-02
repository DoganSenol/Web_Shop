package WebShop_Tricentis;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UsingCouponsAndGiftCards extends ChromeDriver {



    @Test

    public void UsingCouponsAndGiftCaRds() throws AWTException {

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



        WebElement computers = driver.findElement(By.xpath("(//a[@href='/computers'])[1]"));
        MyFunc.Bekle(1);

        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.moveToElement(computers).build();
        aksiyon.perform();
        MyFunc.Bekle(1);

        WebElement notebooks = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
        notebooks.click();
        MyFunc.Bekle(1);

        WebElement addToCartBtn = driver.findElement(By.xpath("//input[@type='button' and @ value='Add to cart']"));
        addToCartBtn.click();
        MyFunc.Bekle(1);

        WebElement soppingCart = driver.findElement(By.xpath("//span[@class='cart-label' and  text()='Shopping cart']"));
        MyFunc.Bekle(1);


        Actions aksiyonlar1 = new Actions(driver);

        Action aksiyon1 = aksiyonlar1.moveToElement(soppingCart).build();
        aksiyon1.perform();
        MyFunc.Bekle(1);

        WebElement GoToCart = driver.findElement(By.xpath("//input[@class='button-1 cart-button']"));
        GoToCart.click();

        WebElement coupon = driver.findElement(By.name("applydiscountcouponcode"));
        coupon.click();

        WebElement message = driver.findElement(By.cssSelector("[class='message']"));

        Assert.assertTrue(message.isDisplayed());
        MyFunc.Bekle(2);

        WebElement giftCard = driver.findElement(By.name("applygiftcardcouponcode"));
        giftCard.click();
        MyFunc.Bekle(1);

        WebElement message2 = driver.findElement(By.cssSelector("[class='message']"));

        Assert.assertTrue(message2.isDisplayed());
        MyFunc.Bekle(1);

        WebElement checkBox = driver.findElement(By.cssSelector("[id='termsofservice'][type='checkbox']"));
        checkBox.click();
        MyFunc.Bekle(1);

        WebElement checkOut = driver.findElement(By.cssSelector("[id='checkout']"));
        checkOut.click();


        WebElement select= driver.findElement(By.name("billing_address_id"));
        select.click();
        MyFunc.Bekle(2);

        Robot robot1=new Robot();
        robot1.keyPress(KeyEvent.VK_DOWN);
        robot1.keyRelease(KeyEvent.VK_DOWN);
        MyFunc.Bekle(2);

        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        MyFunc.Bekle(2);

        WebElement continue2= driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]"));
        continue2.click();
        MyFunc.Bekle(1);

        WebElement continue3= driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button' and @type='button' and @title='Continue' and @value='Continue'])[2]"));
        continue3.click();
        MyFunc.Bekle(1);

        WebElement continue4= driver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']"));
        continue4.click();
        MyFunc.Bekle(1);

        WebElement paymentMethod= driver.findElement(By.id("paymentmethod_2"));
        paymentMethod.click();
        MyFunc.Bekle(1);

        WebElement continue5= driver.findElement(By.cssSelector("[class='button-1 payment-method-next-step-button']"));
        continue5.click();
        MyFunc.Bekle(1);

        WebElement cardHolderName= driver.findElement(By.id("CardholderName"));
        cardHolderName.sendKeys("Ciftlik Bank");
        MyFunc.Bekle(1);

        WebElement cardNumber= driver.findElement(By.id("CardNumber"));
        cardNumber.sendKeys("8561 6730 7128");
        MyFunc.Bekle(1);

        WebElement cardcode= driver.findElement(By.id("CardCode"));
        cardcode.sendKeys("0123");
        MyFunc.Bekle(1);

        WebElement continue6= driver.findElement(By.cssSelector("[class='button-1 payment-info-next-step-button']"));
        continue6.click();
        MyFunc.Bekle(1);



        WebElement confirm= driver.findElement(By.cssSelector("[class='button-1 confirm-order-next-step-button']"));
        confirm.click();
        MyFunc.Bekle(1);


        wait.until(ExpectedConditions.textToBe(By.cssSelector("[class='title']"),"Your order has been successfully processed!") );

        WebElement success= driver.findElement(By.cssSelector("[class='title']"));
        MyFunc.Bekle(1);

        Assert.assertTrue(success.isDisplayed());

        //BekleVeKapat();





    }
}
