package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;
    By addToCartButton = By.xpath("//span[contains(text(),'Add to Cart')]");
    By countryDropdown = By.id("country");
    By stateDropdown = By.id("region_id");
    By zipInput = By.id("postcode");
    By estimateLink = By.xpath("//span[contains(text(),'Estimate')]");
    By tickFlatRate = By.id("s_method_flatrate_flatrate");
    By updateTotalButton = By.xpath("//span[contains(text(),'Update Total')]");
    By proceedToCheckOutButton = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void chooseCountry() {
        WebElement dropdownElement = driver.findElement(countryDropdown);
        Select selectOption = new Select(dropdownElement);
        selectOption.selectByVisibleText("United States");
    }

    public void chooseState() {
        WebElement dropdownElement = driver.findElement(stateDropdown);
        Select selectOption = new Select(dropdownElement);
        selectOption.selectByVisibleText("Florida");
    }

    public void zipEmail(String zip) {
        WebElement emailElement = driver.findElement(zipInput);
        emailElement.clear();
        emailElement.sendKeys(zip);
    }

    public void clickEstimateLink() {
        driver.findElement(estimateLink).click();
    }
    public void clickFlatRate() {
        driver.findElement(tickFlatRate).click();
    }
    public void clickUpdateButton() {
        driver.findElement(updateTotalButton).click();
    }
    public void clickProceedToCheckOutButton() {
        driver.findElement(proceedToCheckOutButton).click();
    }

}
