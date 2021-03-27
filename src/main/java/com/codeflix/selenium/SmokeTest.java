package com.codeflix.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTest {

    @Test
    public void seleniumFirefoxTest() {
        WebDriver browser;
        //Firefox's geckodriver *requires* you to specify its location.
        System.setProperty("webdriver.gecko.driver", "/etc/selenium/geckodriver");
        browser = new FirefoxDriver();
        browser.get("https://hiq.de");
        WebElement header = browser.findElement(By.id("header"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

}
