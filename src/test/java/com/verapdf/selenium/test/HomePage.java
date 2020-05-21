package com.verapdf.selenium.test;

import com.verapdf.selenium.pages.BasePageTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BasePageTest {

    @Test
    public void homePageTest() {
        Assert.assertEquals("veraPDF for WCAG", driver.getTitle());
    }
}