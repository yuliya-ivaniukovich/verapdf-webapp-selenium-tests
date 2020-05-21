package com.verapdf.selenium.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BeforeTest {
    public WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeStart() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\verapdf-webapp-selenium-tests\\chromedriver.exe");
        driver.get("https://verapdf.duallab.com/demo/new-job/files");
        driver.manage().window().setSize(new Dimension(1044, 788));
        driver.manage().timeouts().pageLoadTimeout(60 * 3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}