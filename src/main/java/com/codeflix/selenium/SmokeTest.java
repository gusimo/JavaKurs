package com.codeflix.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BrowserSelectResolver.class)
public class SmokeTest {

    private static WebDriver browser;

    @BeforeAll
    public static void initWebdriver(String browserType){
        System.setProperty("webdriver.gecko.driver", "/etc/selenium/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/etc/selenium/chromedriver");

        if (browserType != null && browserType.equalsIgnoreCase("firefox")) {
            browser = new FirefoxDriver();
        }
        else {
            browser = new ChromeDriver();
        }
    }

    @Test
    public void seleniumTest() {
        browser.get("https://hiq.de");
        WebElement header = browser.findElement(By.id("header"));
        assertTrue((header.isDisplayed()));
        browser.close();
    }

}
