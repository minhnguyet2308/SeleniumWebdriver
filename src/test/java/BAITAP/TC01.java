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

@Test
public class TC01 {
    public static void testTC01() {

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Step1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step2. Verify Title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            //debug purpose only
            Thread.sleep(2000);

            //Step3. Click on -> MOBILE -> menu
            driver.findElement(By.linkText("MOBILE")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Step4. In the list of all mobile , select SORT BY -> dropdown as name
            new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

            //Step5. Verify all products are sorted by name
            String Phone1 = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']")).getText();
            String Phone2 = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='Samsung Galaxy']")).getText();
            String Phone3 = driver.findElement(By.cssSelector("a[title='Sony Xperia']")).getText();
            System.out.println("Phone 1: " + Phone1);
            System.out.println("Phone 2: " + Phone2);
            System.out.println("Phone 3: " + Phone3);
            if (Phone1.compareTo(Phone2) <= 0 && Phone2.compareTo(Phone3) <= 0) {
                System.out.println("All products are sorted by name.");
            } else {
                System.out.println("All products are not sorted by name.");
            }

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC01" + ".png");
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
