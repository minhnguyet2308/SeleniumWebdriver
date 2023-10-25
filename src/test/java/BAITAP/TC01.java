package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;

@Test
public class TC01 {
    public static void testTC01() {
        int scc = 0;

        StringBuffer verificationError = new StringBuffer();

        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Verify Title of the page
            String demoSite = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(demoSite);

            try {
                AssertJUnit.assertEquals("This is demo site for ", demoSite);
            } catch (Error e) {
                verificationError.append(e.toString());
            }

            //debug purpose only
            Thread.sleep(2000);

            //Click on -> MOBILE -> menu
            driver.findElement(By.linkText("MOBILE")).click();

            //debug purpose only
            Thread.sleep(2000);

            //In the list of all mobile , select SORT BY -> dropdown as name
            new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

            //debug purpose only
            Thread.sleep(2000);

            //Verify all products are sorted by name

            scc = (scc + 1);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC01_" + scc + ".png");
            FileUtils.copyFile(scrFile, new File(png));
        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
