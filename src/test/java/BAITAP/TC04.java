package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC04 {
    public static void testTC04() {

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

            //Step3. In mobile products list , click on Add To Compare for 2 mobiles (Sony Xperia & Iphone)
            driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();

            //debug purpose only
            Thread.sleep(2000);

            driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step4. Click on COMPARE button. A popup window opens
            driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]")).click();

            //debug purpose only
            Thread.sleep(2000);

            //switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Step5. Verify the pop-up window and check that the products are reflected in it
            String heading = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText();
            if (heading.isEmpty()) {
                System.out.println("Popup window heading not displayed.");
            } else {
                System.out.println("Popup window heading: " + heading);
            }
            System.out.println("Selected products: ");
            String product1 = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']")).getText();
            String product2 = driver.findElement(By.xpath("//a[normalize-space()='IPhone']")).getText();
            if (product1.isEmpty() || product2.isEmpty()) {
                System.out.println("Selected products are not reflected in popup window");
            } else {
                System.out.println("Selected products are reflected in popup window: ");
                System.out.println(product1);
                System.out.println(product2);
            }

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC04" + ".png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(2000);

            //Step6. Close the Popup Windows
            driver.close();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
