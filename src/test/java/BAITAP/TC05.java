package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import POM.RegisterPage;
import POM.SharedPage;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class TC05 {
    public static void testTC05() {

        // Init web driver session
        String firstName="Nguyen";
        String middleName="Minh";
        String lastName="Nguyet";
        String emailAddress = "nguyet123@gmail.com";
        String password= "123456";
        String confirmPassword= password;
        String emailShared= "nguyet321@gmail.com";
        String message = "Check out my wishlist!";

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

            //Click Create an Account link and fill New User information excluding the registered Email ID
            registerPage.clickCreateAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.enterFirstName(firstName);

            //debug purpose only
            Thread.sleep(2000);

            registerPage.enterMiddleName(middleName);

            //debug purpose only
            Thread.sleep(2000);

            registerPage.enterLastName(lastName);

            //debug purpose only
            Thread.sleep(2000);

            registerPage.enterEmail(emailAddress);

            //debug purpose only
            Thread.sleep(2000);

            registerPage.enterPassword(password);

            //debug purpose only
            Thread.sleep(2000);

            registerPage.enterConfirmPassword(confirmPassword);

            //debug purpose only
            Thread.sleep(2000);

            //Click Register
            registerPage.clickRegister();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Verify Registration is done. Expected account registration done
            String successMessage = driver.findElement(By.cssSelector("li.success-msg span")).getText();
            String successWelcome = driver.findElement(By.cssSelector("p[class='welcome-msg']")).getText();
            if (successMessage.contains("Thank you for registering with Main Website Store.") && successWelcome.contains("WELCOME, " + firstName.toUpperCase() +" "+ middleName.toUpperCase() +" " + lastName.toUpperCase() + "!")) {
                System.out.println("Account registration done.");
            } else {
                System.out.println("Account registration failed.");
            }

            //Screenshot
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC05" + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            //debug purpose only
            Thread.sleep(2000);

            //Go to TV menu
            driver.findElement(By.linkText("TV")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //Click SHARE WISHLIST
            driver.findElement(By.xpath("(//span[contains(text(),'Share Wishlist')])[1]")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //debug purpose only
            Thread.sleep(2000);

            //In next page enter Email and a message and click SHARE WISHLIST
            SharedPage sharedPage = new SharedPage(driver);

            sharedPage.enterEmailShared(emailShared);

            //debug purpose only
            Thread.sleep(2000);

            sharedPage.enterMessageShared(message);

            //debug purpose only
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();

            //debug purpose only
            Thread.sleep(2000);

            //Check wishlist is shared. Expected wishlist shared successfully
            String successMessage2 = driver.findElement(By.xpath("(//span[normalize-space()='Your Wishlist has been shared.'])[1]")).getText();
            if (successMessage2.contains("Your Wishlist has been shared.")) {
                System.out.println("Wishlist shared successfully.");
            } else {
                System.out.println("Wishlist sharing failed.");
            }

            //Screenshot
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC05" + "_2.png");
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
