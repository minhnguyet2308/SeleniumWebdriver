package BAITAP;

import POM.CheckOutPage;
import POM.CartPage;
import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC08 {
    public static void testTC08() {

        String emailAddress = "nguyet321@gmail.com";
        String password = "123456";
        String zip = "5000";

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Step1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //debug purpose only
            Thread.sleep(2000);

            //Step2. Click on my account link
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step3. Login in application using previously created credential
            loginPage.enterEmail(emailAddress);

            //debug purpose only
            Thread.sleep(1000);

            loginPage.enterPassword(password);

            //debug purpose only
            Thread.sleep(1000);

            //Click Login
            loginPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step4. Click on 'REORDER' link , change QTY & click Update
            driver.findElement(By.linkText("REORDER")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            String oldGrandTotal = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$615.00']")).getText();
            System.out.println("Old Grand Total: " + oldGrandTotal);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC08" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            driver.findElement(By.cssSelector("input[title='Qty']")).clear();
            driver.findElement(By.cssSelector("input[title='Qty']")).sendKeys("10");

            //debug purpose only
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step5. Verify Grand Total is changed
            String newGrandTotal = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$6,150.00']")).getText();
            System.out.println("New Grand Total: " + newGrandTotal);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC08" + "_2.png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(2000);

            //Step6. Complete Billing & Shipping Information
            CartPage cartPage = new CartPage(driver);
            cartPage.chooseCountry();

            //debug purpose only
            Thread.sleep(1000);

            cartPage.chooseState();

            //debug purpose only
            Thread.sleep(1000);

            cartPage.zipEmail(zip);

            //debug purpose only
            Thread.sleep(1000);

            cartPage.clickEstimateLink();

            cartPage.clickFlatRate();

            //debug purpose only
            Thread.sleep(2000);

            cartPage.clickUpdateButton();

            //debug purpose only
            Thread.sleep(2000);

            cartPage.clickProceedToCheckOutButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            CheckOutPage checkoutPage = new CheckOutPage(driver);

            checkoutPage.clickContinueBillingButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            checkoutPage.clickContinueShippingMethodButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            checkoutPage.clickChoosePayment();

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.clickContinuePaymentButton();

            //debug purpose only
            Thread.sleep(2000);

            checkoutPage.clickPlaceOrderButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step7. Verify order is generated and note the order number
            String message = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']")).getText();
            String orderID = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//p[1]")).getText();
            System.out.println(message);
            System.out.println(orderID);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC08" + "_3.png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
