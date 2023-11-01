package BAITAP;

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
public class TC06 {

    public static void testTC06() {

        String emailAddress = "nguyet321@gmail.com";
        String password = "123456";
        String zip = "5000";

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //debug purpose only
            Thread.sleep(2000);

            //Click on my account link
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Login in application using previously created credential
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

            //Click on MY WISHLIST link
            driver.findElement(By.linkText("MY WISHLIST")).click();

            //debug purpose only
            Thread.sleep(2000);

            //In next page, Click ADD TO CART link
            CartPage cartPage = new CartPage(driver);
            cartPage.clickAddToCart();

            //debug purpose only
            Thread.sleep(2000);

            //Enter general shipping country, state/province and zip for the shipping cost estimate
            cartPage.chooseCountry();

            //debug purpose only
            Thread.sleep(1000);

            cartPage.chooseState();

            //debug purpose only
            Thread.sleep(1000);

            cartPage.zipEmail(zip);

            //debug purpose only
            Thread.sleep(1000);

            //Click Estimate
            cartPage.clickEstimateLink();

            //Verify Shipping cost generated
//            String subotal = driver.findElement(By.xpath("//tbody//td[@class='a-right']//span[@class='price'][normalize-space()='$615.00']")).getText();
//            String grandTotal = driver.findElement(By.xpath("//span[normalize-space()='$615.00']")).getText();
//            int shippingCost = Integer.parseInt(grandTotal)-Integer.parseInt(subotal);
//            System.out.println("Shipping cost" + shippingCost);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            //Select Shipping Cost, Update Total
            cartPage.clickFlatRate();

            //debug purpose only
            Thread.sleep(2000);

            cartPage.clickUpdateButton();

            //Verify shipping cost is added to total
            String shippingCost = driver.findElement(By.xpath("////td[@class='a-right']//span[@class='price'][normalize-space()='$5.00']")).getText();
            System.out.println("Shipping cost" + shippingCost);

            //debug purpose only
            Thread.sleep(2000);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_2.png");
            FileUtils.copyFile(scrFile, new File(png));

            //Click "Proceed to Checkout"


            //Enter Billing Information, and click Continue

            //Enter Shipping Information, and click Continue

            //In Shipping Method, Click Continue

            //In Payment Information select 'Check/Money Order' radio button. Click Continue

            //Click 'PLACE ORDER' button

            //Verify Oder is generated. Note the order number

        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
