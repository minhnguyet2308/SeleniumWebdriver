package BAITAP;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class TC06 {

    public static void testTC06() {

        String emailAddress = "nhom6@gmail.com";
        String password= "123456";

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


        } catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();

    }
}
