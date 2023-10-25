package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.AssertJUnit.assertEquals;
@Test
public class TC02 {
    public static void testTC02() {

        //Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //debug purpose only
            Thread.sleep(2000);

            //Click on  MOBILE  menu
            driver.findElement(By.linkText("MOBILE")).click();

            //debug purpose only
            Thread.sleep(2000);

            //In the list of all mobile, read the cost of Sony Xperia mobile (which is $100)
            String PriceInList = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
            System.out.println("Product value in list: " + PriceInList);

            //debug purpose only
            Thread.sleep(2000);

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC02" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            //Click on Sony Xperia mobile
            driver.findElement(By.id("product-collection-image-1")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Read the Sony Xperia mobile from detail page.
            String PriceInDetailPage = driver.findElement(By.cssSelector("span.price")).getText();
            System.out.println("Product value in detail page: " + PriceInDetailPage);

            //Compare Product value in list and details page should be equal ($100).
            assertEquals(PriceInList, PriceInDetailPage);
            if (PriceInList.equals(PriceInDetailPage)) {
                System.out.println("Product value in list and detail page is equal: " + PriceInDetailPage);
            } else {
                System.out.println("Product value in list and detail page is not equal");
            }

            //debug purpose only
            Thread.sleep(2000);

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC02" + "_2.png");
            FileUtils.copyFile(scrFile, new File(png));
        }catch (Exception e){
            e.printStackTrace();
        }

        // Quit browser session
        driver.quit();

    }
}
