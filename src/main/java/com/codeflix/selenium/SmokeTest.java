package com.codeflix.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
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
    public void checkHeader() {
        browser.get("https://hiq.de");

        String[] expected = new String[7];
        expected[0] = "Über HiQ";
        expected[1] = "Leistungen";
        expected[2] = "Unsere Kunden";
        expected[3] = "Karriere";
        expected[4] = "News & Presse";
        expected[5] = "Webinare & Events";
        expected[6] = "Kontakt";

        List<WebElement> items = browser.findElements(By.className("menu-item"));

        for (String expectedItem:expected) {
            boolean foundItem = false;
            for(WebElement existingItem: items) {
                if (existingItem.getText().equals(expectedItem)) {
                    foundItem = true;
                }
            }
            assertTrue(foundItem, expectedItem);
        }
    }

    @Test
    public void checkMenu() {
        browser.get("https://hiq.de");
        WebElement header = browser.findElement(By.id("header"));
        assertTrue((header.isDisplayed()));
    }

    @AfterAll
    public static void closeBrowser() {
        browser.close();
    }

}
