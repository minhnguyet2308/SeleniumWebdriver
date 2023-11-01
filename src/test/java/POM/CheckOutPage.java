package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    WebDriver driver;

    By addressSelectorBilling = By.id("billing-address-select");
    By firstNameBillingInputLocator = By.id("billing:firstname");
    By middleNameBillingInputLocator = By.id("billing:middlename");
    By lastNameBillingInputLocator = By.id("billing:lastname");
    By companyBillingInputLocator = By.id("billing:company");
    By address1BillingInputLocator = By.id("billing:street1");
    By address2BillingInputLocator = By.id("billing:street2");
    By cityBillingInputLocator = By.id("billing:city");
    By stateBillingSelector = By.id("billing:region_id");
    By zipBillingInputLocator = By.id("billing:postcode");
    By countryBillingSelector = By.id("billing:country_id");
    By telephoneBillingInputLocator = By.id("billing:telephone");
    By faxBillingInputLocator = By.id("billing:fax");
    By shipToDifferentAddress = By.xpath("//label[normalize-space()='Ship to different address']");
    By continueBillingButton = By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]");
    By addressSelectorShipping = By.id("shipping-address-select");
    By firstNameShippingInputLocator = By.id("shipping:firstname");
    By middleNameShippingInputLocator = By.id("shipping:middlename");
    By lastNameShippingInputLocator = By.id("shipping:lastname");
    By companyShippingInputLocator = By.id("shipping:company");
    By address1ShippingInputLocator = By.id("shipping:street1");
    By address2ShippingInputLocator = By.id("shipping:street2");
    By cityShippingInputLocator = By.id("shipping:city");
    By stateShippingSelector = By.id("shipping:region_id");
    By zipShippingInputLocator = By.id("shipping:postcode");
    By countryShippingSelector = By.id("shipping:country_id");
    By telephoneShippingInputLocator = By.id("shipping:telephone");
    By faxShippingInputLocator = By.id("shipping:fax");
    By continueShippingButton = By.xpath("//button[@onclick='shipping.save()']//span//span[contains(text(),'Continue')]");
    By continueShippingMethodButton = By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]");
    By continuePaymentButton = By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectAddressBilling(String address){
        WebElement addressElement = driver.findElement(addressSelectorBilling);
        Select select = new Select(addressElement);
        select.selectByVisibleText(address);
    }
    public void enterFirstNameBilling(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameBillingInputLocator);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }
    public void enterMiddleNameBilling(String middleName){
        WebElement middleNameElement = driver.findElement(middleNameBillingInputLocator);
        middleNameElement.clear();
        middleNameElement.sendKeys(middleName);
    }
    public void enterLastNameBilling(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameBillingInputLocator);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }
    public void enterCompanyBilling(String company){
        WebElement companyElement = driver.findElement(companyBillingInputLocator);
        companyElement.clear();
        companyElement.sendKeys(company);
    }
    public void enterAddress1Billing(String address1){
        WebElement address1Element = driver.findElement(address1BillingInputLocator);
        address1Element.clear();
        address1Element.sendKeys(address1);
    }
    public void enterAddress2Billing(String address2){
        WebElement address2Element = driver.findElement(address2BillingInputLocator);
        address2Element.clear();
        address2Element.sendKeys(address2);
    }
    public void enterCityBilling(String city){
        WebElement cityElement = driver.findElement(cityBillingInputLocator);
        cityElement.clear();
        cityElement.sendKeys(city);
    }
    public void selectStateBilling(String state){
        WebElement stateElement = driver.findElement(stateBillingSelector);
        Select select = new Select(stateElement);
        select.selectByVisibleText(state);
    }
    public void enterZipBilling(String zip){
        WebElement zipElement = driver.findElement(zipBillingInputLocator);
        zipElement.clear();
        zipElement.sendKeys(zip);
    }
    public void selectCountryBilling(String country){
        WebElement countryElement = driver.findElement(countryBillingSelector);
        Select select = new Select(countryElement);
        select.selectByVisibleText(country);
    }
    public void enterTelephoneBilling(String telephone){
        WebElement telephoneElement = driver.findElement(telephoneBillingInputLocator);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }
    public void enterFaxBilling(String fax){
        WebElement faxElement = driver.findElement(faxBillingInputLocator);
        faxElement.clear();
        faxElement.sendKeys(fax);
    }
    public void clickShipToDifferentAddress() {
        driver.findElement(shipToDifferentAddress).click();
    }
    public void clickContinueBillingButton() {
        driver.findElement(continueBillingButton).click();
    }
    public void selectAddressShipping(String address){
        WebElement addressElement = driver.findElement(addressSelectorShipping);
        Select select = new Select(addressElement);
        select.selectByVisibleText(address);
    }
    public void enterFirstNameShipping(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameShippingInputLocator);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }
    public void enterMiddleNameShipping(String middleName){
        WebElement middleNameElement = driver.findElement(middleNameShippingInputLocator);
        middleNameElement.clear();
        middleNameElement.sendKeys(middleName);
    }
    public void enterLastNameShipping(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameShippingInputLocator);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }
    public void enterCompanyShipping(String company){
        WebElement companyElement = driver.findElement(companyShippingInputLocator);
        companyElement.clear();
        companyElement.sendKeys(company);
    }
    public void enterAddress1Shipping(String address1){
        WebElement address1Element = driver.findElement(address1ShippingInputLocator);
        address1Element.clear();
        address1Element.sendKeys(address1);
    }
    public void enterAddress2Shipping(String address2){
        WebElement address2Element = driver.findElement(address2ShippingInputLocator);
        address2Element.clear();
        address2Element.sendKeys(address2);
    }
    public void enterCityShipping(String city){
        WebElement cityElement = driver.findElement(cityShippingInputLocator);
        cityElement.clear();
        cityElement.sendKeys(city);
    }
    public void selectStateShipping(String state){
        WebElement stateElement = driver.findElement(stateShippingSelector);
        Select select = new Select(stateElement);
        select.selectByVisibleText(state);
    }
    public void enterZipShipping(String zip){
        WebElement zipElement = driver.findElement(zipShippingInputLocator);
        zipElement.clear();
        zipElement.sendKeys(zip);
    }
    public void selectCountryShipping(String country){
        WebElement countryElement = driver.findElement(countryShippingSelector);
        Select select = new Select(countryElement);
        select.selectByVisibleText(country);
    }
    public void enterTelephoneShipping(String telephone){
        WebElement telephoneElement = driver.findElement(telephoneShippingInputLocator);
        telephoneElement.clear();
        telephoneElement.sendKeys(telephone);
    }
    public void enterFaxShipping(String fax){
        WebElement faxElement = driver.findElement(faxShippingInputLocator);
        faxElement.clear();
        faxElement.sendKeys(fax);
    }
    public void clickContinueShippingButton() {
        driver.findElement(continueShippingButton).click();
    }
    public void clickContinueShippingMethodButton() {
        driver.findElement(continueShippingMethodButton).click();
    }
    public void clickContinuePaymentButton() {
        driver.findElement(continuePaymentButton).click();
    }
}