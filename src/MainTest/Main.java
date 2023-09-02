package MainTest;

import drivers.ChromeDriver;
import drivers.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main  extends ChromeDriver {

    By rgs = By.cssSelector("a[href='/register']");
    By gnd = By.cssSelector("input[id='gender-male']");
    By fName = By.cssSelector("input[id='FirstName']");
    By lName = By.cssSelector("input[id='LastName']");
    By mail = By.cssSelector("input[id='Email']");
    By pswd = By.cssSelector("input[id='Password']");
    By Cpswd = By.cssSelector("input[id='ConfirmPassword']");
    By RgBtn = By.cssSelector("input[id='register-button']");


    @Test(priority = 1)

    public void createAccount() {


        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(rgs);
        register.click();

        WebElement gender = driver.findElement(gnd);
        gender.click();

        WebElement firstName = driver.findElement(fName);
        firstName.sendKeys("Senol");

        WebElement lastName = driver.findElement(lName);
        lastName.sendKeys("Dogan");

        WebElement eMail = driver.findElement(mail);
        eMail.sendKeys("senoldogan2018@gmail.com");

        WebElement password = driver.findElement(pswd);
        password.sendKeys("Senol1988++");

        WebElement Confirmpassword = driver.findElement(Cpswd);
        Confirmpassword.sendKeys("Senol1988++");

        WebElement registerButton = driver.findElement(RgBtn);
        registerButton.click();

        //  BekleVeKapat();

    }


    @Test(priority = 7)

    public void login() {

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


        // BekleVeKapat();
    }


    @Test(priority = 11)

    public void logOut() {

        driver.get("https://demowebshop.tricentis.com/");


        WebElement logOut = driver.findElement(By.cssSelector("[class='ico-logout']"));
        logOut.click();

        //BekleVeKapat();
    }

    @Test(priority = 2)
    public void NegativeCreateAccountTest() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        MyFunc.Bekle(2);
        WebElement gender = driver.findElement(By.cssSelector("[id='gender-male']"));
        gender.click();
        MyFunc.Bekle(2);
        WebElement ad = driver.findElement(By.id("FirstName"));
        ad.sendKeys("Murat");
        MyFunc.Bekle(2);
        WebElement soyad = driver.findElement(By.id("LastName"));
        soyad.sendKeys("Yagmur");
        MyFunc.Bekle(2);
        WebElement mail = driver.findElement(By.id("Email"));
        mail.sendKeys("senoldogan2018@gmail.com");
        MyFunc.Bekle(2);
        WebElement sifre = driver.findElement(By.id("Password"));
        sifre.sendKeys("Senol1988++");
        MyFunc.Bekle(2);
        WebElement sifreTekrar = driver.findElement(By.id("ConfirmPassword"));
        sifreTekrar.sendKeys("Senol1988++");
        MyFunc.Bekle(2);
        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();
        MyFunc.Bekle(2);
        WebElement msj = driver.findElement(By.xpath("//*[text()='The specified email already exists']"));

        Assert.assertTrue(msj.getText().contains("The specified email already exists"));


    }

    @Test(priority = 3)
    public void NegativeLogin_01_() {

        //Bos Mail ve Password girerek test etme
        driver.get("https://demowebshop.tricentis.com/login");


        WebElement Login = driver.findElement(By.xpath("//a[@href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.cssSelector("input[id='Email']"));
        Email.sendKeys("");

        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Password.sendKeys("");

        WebElement LoginBtn = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        LoginBtn.click();
        MyFunc.Bekle(1);

        WebElement error = driver.findElement(By.cssSelector("[class='validation-summary-errors']"));
        Assert.assertTrue(error.isDisplayed());

    }

    @Test(priority = 4)
    public void NegativeLogin_02_() {

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




    }

    @Test(priority = 5)
    public void NegativeLogin_03_() {

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


    }

    @Test(priority = 6)
    public void NegativeLogin_04_() {

        //Gecersiz Mail ve  gecersiz Password girerek test etme
        driver.get("https://demowebshop.tricentis.com/login");

        WebElement Login = driver.findElement(By.xpath("//a[@href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.cssSelector("input[id='Email']"));
        Email.sendKeys("dogan2018@gmail.com");

        WebElement Password = driver.findElement(By.cssSelector("input[id='Password']"));
        Password.sendKeys("1988++");

        WebElement LoginBtn = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        LoginBtn.click();
        MyFunc.Bekle(1);

        WebElement error = driver.findElement(By.cssSelector("[class='validation-summary-errors']"));
        Assert.assertTrue(error.isDisplayed());

    }



    @Test(priority = 10)

    public void orderHistoryDownloaD() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");


        WebElement Account = driver.findElement(By.cssSelector("a[class='account']"));
        Account.click();
        MyFunc.Bekle(1);

        WebElement Orders = driver.findElement(By.xpath("//a[@href='/customer/orders']"));
        Orders.click();
        MyFunc.Bekle(1);


        MyFunc.Bekle(1);

        WebElement Details = driver.findElement(By.cssSelector("input[class='button-2 order-details-button']"));
        Details.click();
        MyFunc.Bekle(1);

        WebElement Pdf = driver.findElement(By.cssSelector("[class='button-2 pdf-order-button']"));
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







    }

    @Test(priority = 9)
    public void ordering() {

        driver.get("https://demowebshop.tricentis.com/");


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


        org.testng.Assert.assertTrue(toplamFiyat == doubleTotalFee, "Urun fiyatiyla ek odemelerin fiyatinin toplami Toplam odenecek fiyata esit degil.");

        WebElement confirm = driver.findElement(By.cssSelector("[class='button-1 confirm-order-next-step-button']"));
        confirm.click();
        MyFunc.Bekle(2);

        WebElement success = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));

        org.testng.Assert.assertTrue(success.getText().contains("Your order has been successfully"), "Siparis gerceklesmedi.");





    }

    @Test(priority = 8)

    public void UsingCouponsAndGiftCaRds() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");




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








    }


}