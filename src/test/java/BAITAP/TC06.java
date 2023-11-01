package BAITAP;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class TC06 {

    public static void testTC05() {
        //init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            //Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //debug purpose only
            Thread.sleep(2000);

            //Click on my account link
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.clickMyAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Login in application using previously created credential


        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
