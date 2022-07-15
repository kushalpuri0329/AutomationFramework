package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class TestCase {
    @Test
    public void dummyTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebElement element = null;

        driver.get("http://google.com");
        element.findElement(By.cssSelector("input[title='Search']")).sendKeys("fsfs");
        driver.quit();
    }
}
