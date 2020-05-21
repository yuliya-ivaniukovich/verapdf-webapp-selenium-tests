package com.verapdf.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.MessageFormat;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BasePageTest extends BeforeTest {

    public WebDriver getDriver() {
        return driver;
    }
    public void waitUntilElementIsPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }
    public void verifyElementPresentBySelector(By selector) {
        Assert.assertTrue(driver.findElements(selector).size() != 0, MessageFormat.format("Element with selector {0} is not present", selector));
    }

    public void verifyElementNotPresentBySelector(By selector) {
        Assert.assertTrue(driver.findElements(selector).size() == 0, MessageFormat.format("Element with selector {0} is not present", selector));
    }
    public void verifyInputtedValueInTextFieldInPreview(By selector, String value) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("pageNumber"));
        assertEquals(jse.executeScript("return arguments[0].value", element), value);
    }
}