package WebShop_Tricentis;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ordering extends ChromeDriver {
    @Test
    public void ordering() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("1a@mail.ru");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Bishkek2023");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value='Log in']"));
        loginBtn.click();
        MyFunc.Bekle(1);

        WebElement computers = driver.findElement(By.xpath("(//a[@href='/computers'])[1]"));
        MyFunc.Bekle(1);

        Actions aksiyonlar = new Actions(driver);

        Action aksiyon = aksiyonlar.moveToElement(computers).build();
        aksiyon.perform();
        MyFunc.Bekle(1);

        WebElement notebooks = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
        notebooks.click();
        MyFunc.Bekle(2);

        WebElement addToCartBtn = driver.findElement(By.xpath("//input[@type='button' and @ value='Add to cart']"));
        addToCartBtn.click();
        MyFunc.Bekle(1);

        WebElement shoppingCart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCart.click();

        WebElement selectCounty = driver.findElement(By.cssSelector("[id='CountryId']"));

        Select country = new Select(selectCounty);
        country.selectByVisibleText("United States");

        WebElement selectState = driver.findElement(By.cssSelector("[id='StateProvinceId']"));
        MyFunc.Bekle(2);

        Select state = new Select(selectState);
        state.selectByVisibleText("Alabama");
        MyFunc.Bekle(1);

        WebElement agree = driver.findElement(By.cssSelector("[id='termsofservice']"));
        agree.click();
        MyFunc.Bekle(1);

        WebElement checkout = driver.findElement(By.cssSelector("[id='checkout']"));
        checkout.click();
        MyFunc.Bekle(1);

        WebElement address = driver.findElement(By.cssSelector("[id='billing-address-select']"));

        Select selectNewAddrss = new Select(address);
        selectNewAddrss.selectByVisibleText("New Address");
        MyFunc.Bekle(1);

        WebElement selectCountry3 = driver.findElement(By.cssSelector("[id='BillingNewAddress_CountryId']"));

        Select country2 = new Select(selectCountry3);
        country2.selectByVisibleText("United States");
        MyFunc.Bekle(2);

        WebElement selectState2 = driver.findElement(By.cssSelector("[id='BillingNewAddress_StateProvinceId']"));

        Select state2 = new Select(selectState2);
        state2.selectByVisibleText("Alabama");

        WebElement city = driver.findElement(By.cssSelector("[id='BillingNewAddress_City']"));
        city.sendKeys("Bulls");

        WebElement firstAddress = driver.findElement(By.cssSelector("[id='BillingNewAddress_Address1']"));
        firstAddress.sendKeys("lala");

        WebElement zipCode = driver.findElement(By.cssSelector("[id='BillingNewAddress_ZipPostalCode']"));
        zipCode.sendKeys("123");

        WebElement phoneNumber = driver.findElement(By.cssSelector("[id='BillingNewAddress_PhoneNumber']"));
        phoneNumber.sendKeys("11111");

        WebElement continue2 = driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]"));
        continue2.click();
        MyFunc.Bekle(2);

        WebElement inStorePickup = driver.findElement(By.id("PickUpInStore"));
        inStorePickup.click();

        MyFunc.Bekle(1);

        WebElement continue3 = driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]"));
        continue3.click();
        MyFunc.Bekle(2);

        WebElement continue4 = driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));
        continue4.click();

        MyFunc.Bekle(2);

        WebElement continue5 = driver.findElement(By.cssSelector("[onclick='PaymentInfo.save()']"));
        continue5.click();
        MyFunc.Bekle(3);

        WebElement total = driver.findElement(By.cssSelector("[class='product-subtotal']"));

        WebElement addFee = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));

        WebElement totalFee = driver.findElement(By.cssSelector("[class='product-price order-total']"));
        Double doubleTotalFee = Double.parseDouble(totalFee.getText());

        double doubleTotal = Double.parseDouble(total.getText());
        double doubleAddFee = Double.parseDouble(addFee.getText());

        double toplamFiyat = doubleTotal + doubleAddFee;


        Assert.assertTrue(toplamFiyat == doubleTotalFee, "Urun fiyatiyla ek odemelerin fiyatinin toplami Toplam odenecek fiyata esit degil.");

        WebElement confirm = driver.findElement(By.cssSelector("[class='button-1 confirm-order-next-step-button']"));
        confirm.click();
        MyFunc.Bekle(2);

        WebElement success = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));

        Assert.assertTrue(success.getText().contains("Your order has been successfully"), "Siparis gerceklesmedi.");


        BekleVeKapat();


    }
}
