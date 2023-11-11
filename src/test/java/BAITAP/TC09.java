package BAITAP;

import POM.CartPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC09 {

    public static void testTC09() {

        String couponCode = "GURU50";

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Step1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //debug purpose only
            Thread.sleep(2000);

            //Step2. Go to Mobile and add IPHONE to cart
            driver.findElement(By.linkText("MOBILE")).click();

            //debug purpose only
            Thread.sleep(2000);

            CartPage cartPage = new CartPage(driver);
            cartPage.clickAddToCart();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step3. Enter Coupon Code
            cartPage = new CartPage(driver);
            cartPage.enterCoupon(couponCode);

            //debug purpose only
            Thread.sleep(1000);

            cartPage.clickApplyCoupon();

            //debug purpose only
            Thread.sleep(2000);

            //Step4. Verify the discount generated
            String subTotal = driver.findElement(By.xpath("//tbody//td[@class='a-right']//span[@class='price'][normalize-space()='$500.00']")).getText();
            String discount = driver.findElement(By.xpath("//span[normalize-space()='-$25.00']")).getText();
            System.out.println("SUBTOTAL: " + subTotal);
            System.out.println("DISCOUNT: " + discount);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC09" + ".png");
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
