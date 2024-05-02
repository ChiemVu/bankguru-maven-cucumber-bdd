package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void openPageUrl(String pageUrl) {
        driver.get(pageUrl);
    }
    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }
    private By getByLocator(String locatorType){
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")){
            locatorType = locatorType.substring(3);
            by = By.id(locatorType);
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
            locatorType = locatorType.substring(6);
            by = By.className(locatorType);
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
            locatorType = locatorType.substring(5);
            by = By.name(locatorType);
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
            locatorType = locatorType.substring(4);
            by = By.cssSelector(locatorType);
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
            locatorType = locatorType.substring(6);
            by = By.xpath(locatorType);
        } else {
            throw new RuntimeException("Locator type is not supprot");
        }
        return by;
    }

    public String getDynamicXpath(String locatorType, String... dynamicValues) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")
                || locatorType.startsWith("Xpath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValues);
        }
        return locatorType;
    }

    public WebElement getWebElement(String locatorType){
        return driver.findElement(getByLocator(locatorType));
    }
    public String getElementText(String locatorType){
        return driver.findElement(getByLocator(locatorType)).getText();
    }
    public String getElementText(String locatorType, String... dynamicValues){
        return driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValues))).getText();
    }
    public void waitForElementVisible(String locatorType){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstant().getLongTime())).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }
    public void waitForElementVisible(String locatorType, String... dynamicValues){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstant().getLongTime())).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }
    public void waitForElementClickable(String locatorType){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstant().getLongTime())).until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }
    public void waitForElementClickable(String locatorType, String... dynamicValues){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstant().getLongTime())).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
    }
    public Alert waitForAlertPresence() {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalConstant().getLongTime())).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert() {
        waitForAlertPresence().accept();
    }
    public String getTextInAlert() {
        return waitForAlertPresence().getText();
    }

    public void sendKeyToElement(String locator, String keyToSend){
        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void sendKeyToElement(String locator, String keyToSend, String...dynamicValues){
        WebElement element = getWebElement(getDynamicXpath(locator, dynamicValues));
        element.clear();
        element.sendKeys(keyToSend);
    }
    public void sendKeyboardToElement(String locator, Keys key){
        WebElement element = getWebElement(locator);
        element.clear();
        Actions action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }
    public void sendKeyboardToElement(String locatorType, Keys key, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValues));
        element.clear();
        Actions action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }
    public void removeAttributeInDOM(String locator, String attributeRemove, String...dynamicValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(getDynamicXpath(locator, dynamicValue)));
    }

    public void clickToElement(String locatorType){
        if (driver.toString().contains("internet explorer")){
            clickToElementByJS(locatorType);
            sleepInSecond(3);
        }else {
            getWebElement(locatorType).click();
        }
    }

    public void clickToElement(String locatorType, String...dynamicValues){
        locatorType = getDynamicXpath(locatorType, dynamicValues);
        if (driver.toString().contains("internet explorer")){
            clickToElementByJS(locatorType);
            sleepInSecond(3);
        }else {
            getWebElement(locatorType).click();
        }
    }
    public void clickToElementByJS(String locatorType){
        JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
        jsExcutor.executeScript("arguments[0].click();", getWebElement(locatorType));
    }
    // Default Checkbox/ Radio
    public void checkToElement(String locator, String... dynamicValues) {
        if (!getWebElement(getDynamicXpath(locator, dynamicValues)).isSelected()) {
            getWebElement(getDynamicXpath(locator, dynamicValues)).click();
        }
    }

    public void selectItemInDefaultDropdown(String locator, String itemValue) {
        new Select(getWebElement(locator)).selectByVisibleText(itemValue);
    }
    public boolean isElementDisplayed(String locator){
        return getWebElement(locator).isDisplayed();
    }
    public boolean isElementDisplayed(String locator, String...dynamicValues){
        return getWebElement(getDynamicXpath(locator, dynamicValues)).isDisplayed();
    }


    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
