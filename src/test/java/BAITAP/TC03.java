package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC03 {
    public static void testTC03() {

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Step1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //debug purpose only
            Thread.sleep(2000);

            //Step2. Click on -> MOBILE -> menu
            driver.findElement(By.linkText("MOBILE")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step3. In the list of all mobile , click on ADD TO CART for Sony Xperia mobile
            driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step4. Change QTY value to 1000 and click UPDATE button
            //Expected that an error is displayed "The requested quantity for "Sony Xperia" is not available.
            driver.findElement(By.cssSelector("input[title='Qty']")).clear();
            driver.findElement(By.cssSelector("input[title='Qty']")).sendKeys("1000");

            //debug purpose only
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step5. Verify the error message
            String errorMessage = driver.findElement(By.cssSelector(".item-msg.error")).getText();
            System.out.println("Error Message: " + errorMessage);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC03" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(2000);

            //Step6. Then click on EMPTY CART link in the footer of list of all mobiles.
            //A message "SHOPPING CART IS EMPTY" is shown.
            driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click();
            String emptyMessage = driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart is Empty']")).getText();
            System.out.println("Empty Message: " + emptyMessage);

            //Step7. Verify cart is empty
            String cartMessage = driver.findElement(By.xpath("//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]")).getText();
            System.out.println("Cart: " + cartMessage);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC03" + "_2.png");
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
