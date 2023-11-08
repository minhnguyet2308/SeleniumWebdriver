package BAITAP;

import POM.AdminPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC10 {

    public static void testTC10() {

        String id = "user01";
        String pass = "guru99com";
        String orderID = "158";
        String fromDate = "11/6/2023";
        String toDate = "11/8/2023";

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Step1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            //debug purpose only
            Thread.sleep(2000);

            //Step2. Login the credentials provided
            AdminPage adminPage = new AdminPage(driver);
            adminPage.enterUserName(id);

            //debug purpose only
            Thread.sleep(1000);

            adminPage.enterPassword(pass);

            //debug purpose only
            Thread.sleep(1000);

            adminPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            adminPage.clickCloseMessage();

            //debug purpose only
            Thread.sleep(2000);

            //Step3. Go to Sales-> Orders menu
            adminPage.clickSalesMenu();
            adminPage.clickOrderMenu();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Step4. Input OrderId and FromDate -> ToDate
            adminPage.enterOrderID(orderID);

            //debug purpose only
            Thread.sleep(1000);

            adminPage.enterFromDate(fromDate);

            //debug purpose only
            Thread.sleep(1000);

            adminPage.enterToDate(toDate);

            //debug purpose only
            Thread.sleep(1000);

            //Step5. Click Search button
            adminPage.clickSearchButton();

            //debug purpose only
            Thread.sleep(1000);

            //6. Screenshot capture.
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC10" + ".png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(1000);

        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
