package org.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class Page {
    final WebDriver driver;
    WebDriverWait webDriverWait;

    // non-abstract methods
    public Page(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        this.webDriverWait = webDriverWait;
    }

    // abstract methods
    public abstract String getPageTitle();

    public abstract String getPageHeader();

    public abstract String getPageHeader(By locator);

    public abstract WebElement getElement(By locator);

    public abstract void waitForElement(By locator);

    public abstract void waitForPageTitle(String title);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            System.out.println("Error creating an instance " + e.getStackTrace());
        }
            return null;
    }
}



