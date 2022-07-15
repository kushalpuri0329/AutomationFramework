package org.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page{

    public BasePage(WebDriver driver,WebDriverWait webDriverWait) {
        super(driver,webDriverWait);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getPageHeader() {
        return null;
    }

    @Override
    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }

    @Override
    public WebElement getElement(By locator) {
        WebElement webElement=null;
        webElement.findElement(locator);
        return webElement;
    }

    @Override
    public void waitForElement(By locator) {
       webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public void waitForPageTitle(String title) {
        webDriverWait.until(ExpectedConditions.titleContains(title));
    }
}
