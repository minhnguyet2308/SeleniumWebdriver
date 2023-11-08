package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {

    WebDriver driver;

    By userNameInput = By.id("username");
    By passwordInput = By.id("login");
    By loginButton = By.cssSelector("input[title='Login']");
    By closeMessageButton = By.xpath("//span[normalize-space()='close']");
    By salesMenu = By.xpath("//span[normalize-space()='Sales']");
    By orderMenu = By.xpath("//span[normalize-space()='Orders']");
    By orderIdInput = By.id("sales_order_grid_filter_real_order_id");
    By fromDateInput = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");
//    By fromDateSelect = By.id("sales_order_grid_filter_created_at1699426662.3558_from_trig");
    By toDateInput = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");
//    By toDateSelect = By.id("sales_order_grid_filter_created_at1699426662.3558_to_trig");
    By searchButton = By.xpath("//span[contains(text(),'Search')]");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String userName) {
        WebElement userNameElement = driver.findElement(userNameInput);
        userNameElement.clear();
        userNameElement.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void clickCloseMessage() {
        driver.findElement(closeMessageButton).click();
    }
    public void clickSalesMenu() {
        driver.findElement(salesMenu).click();
    }
    public void clickOrderMenu() {
        driver.findElement(orderMenu).click();
    }
    public void enterOrderID(String orderID) {
        WebElement orderIdElement = driver.findElement(orderIdInput);
        orderIdElement.clear();
        orderIdElement.sendKeys(orderID);
    }
    public void enterFromDate(String FromDate) {
        WebElement fromDateElement = driver.findElement(fromDateInput);
        fromDateElement.clear();
        fromDateElement.sendKeys(FromDate);
    }
//    public void selectFromDate(String fromDate){
//        WebElement fromDateElement = driver.findElement(fromDateSelect);
//        Select select = new Select(fromDateElement);
//        select.selectByVisibleText(fromDate);
//    }
    public void enterToDate(String ToDate) {
        WebElement toDateElement = driver.findElement(toDateInput);
        toDateElement.clear();
        toDateElement.sendKeys(ToDate);
    }
//    public void selectToDate(String toDate){
//        WebElement toDateElement = driver.findElement(toDateSelect);
//        Select select = new Select(toDateElement);
//        select.selectByVisibleText(toDate);
//    }
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
