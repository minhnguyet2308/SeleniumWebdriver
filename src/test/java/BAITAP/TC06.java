package BAITAP;

import POM.LoginPage;
import POM.CartPage;
import POM.CheckOutPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC06 {

    public static void testTC06() {

        String emailAddress = "nguyet321@gmail.com";
        String password = "123456";
        String zip = "5000";
        String address="New Address";
        String firstName ="Group";
        String lastName ="Six";
        String address1 ="NVH";
        String city ="HCM";
        String state ="Florida";
        String country ="United States";
        String telephone ="1234567890";
        String company ="HCM";

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

            //Step4. Click on MY WISHLIST link
            driver.findElement(By.linkText("MY WISHLIST")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step5. In next page, Click ADD TO CART link
            CartPage cartPage = new CartPage(driver);
            cartPage.clickAddToCart();

            //debug purpose only
            Thread.sleep(2000);

            //Step6. Enter general shipping country, state/province and zip for the shipping cost estimate
            cartPage.chooseCountry();

            //debug purpose only
            Thread.sleep(1000);

            cartPage.chooseState();

            //debug purpose only
            Thread.sleep(1000);

            cartPage.zipEmail(zip);

            //debug purpose only
            Thread.sleep(1000);

            //Step7. Click Estimate
            cartPage.clickEstimateLink();

            //Step8. Verify Shipping cost generated
            String flatRate = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']")).getText();
            String valueFlatRate = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText();
            System.out.println("Shipping cost generated: " + flatRate);
            System.out.println("Value: " + valueFlatRate);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            //Step9. Select Shipping Cost, Update Total
            cartPage.clickFlatRate();

            //debug purpose only
            Thread.sleep(2000);

            cartPage.clickUpdateButton();

            //Step11. Verify shipping cost is added to total
            String subTotal = driver.findElement(By.xpath("//tbody//td[@class='a-right']//span[@class='price'][normalize-space()='$615.00']")).getText();
            String shippingCost = driver.findElement(By.xpath("//td[@class='a-right']//span[@class='price'][normalize-space()='$5.00']")).getText();
            String grandTotal = driver.findElement(By.xpath("//span[normalize-space()='$620.00']")).getText();
            System.out.println("Sub Total: " + subTotal);
            System.out.println("Shipping cost" + shippingCost);
            System.out.println("Grand Total: " + grandTotal);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_2.png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(2000);

            //Step11. Click "Proceed to Checkout"
            cartPage.clickProceedToCheckOutButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step12a. Enter Billing Information, and click Continue
            CheckOutPage checkoutPage = new CheckOutPage(driver);
            checkoutPage.selectAddressBilling(address);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterFirstNameBilling(firstName);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterLastNameBilling(lastName);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterCompanyBilling(company);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterAddress1Billing(address1);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterCityBilling(city);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.selectStateBilling(state);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterZipBilling(zip);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.selectCountryBilling(country);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterTelephoneBilling(telephone);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.clickShipToDifferentAddress();

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.clickContinueBillingButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step12b. Enter Shipping Information, and click Continue
            checkoutPage.selectAddressShipping(address);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterFirstNameShipping(firstName);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterLastNameShipping(lastName);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterCompanyShipping(company);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterAddress1Shipping(address1);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterCityShipping(city);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.selectStateShipping(state);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterZipShipping(zip);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.selectCountryShipping(country);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.enterTelephoneShipping(telephone);

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.clickContinueShippingButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step13. In Shipping Method, Click Continue
            checkoutPage.clickContinueShippingMethodButton();

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step14. In Payment Information select 'Check/Money Order' radio button. Click Continue
            checkoutPage.clickChoosePayment();

            //debug purpose only
            Thread.sleep(1000);

            checkoutPage.clickContinuePaymentButton();

            //debug purpose only
            Thread.sleep(2000);

            //Step15. Click 'PLACE ORDER' button
            checkoutPage.clickPlaceOrderButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step16. Verify Oder is generated. Note the order number
            String message = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']")).getText();
            String orderID = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//p[1]")).getText();
            System.out.println(message);
            System.out.println(orderID);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_3.png");
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
