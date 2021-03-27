package com.codeflix.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BrowserSelectResolver.class)
public class CRMTest {

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
    @Order(1)
    public void Login(TestReporter reporter) {
        browser.get("http://crm.hiq.de");
        WebElement username = browser.findElement(By.id("user_name"));
        username.clear();
        username.sendKeys("gsimon");

        WebElement password = browser.findElement(By.id("username_password"));
        password.clear();
        password.sendKeys("LiM#m0cS");

        WebElement loginbutton = browser.findElement(By.id("bigbutton"));
        loginbutton.click();
    }

    @Test
    @Order(10)
    public void createLead(TestReporter reporter) {
        browser.get("http://crm.hiq.de/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Dindex%26parentTab%3DMarketing");

        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action-name='Create']")));

        WebElement createButton = browser.findElement(By.xpath("//a[@data-action-name='Create']"));
        createButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
        WebElement firstName = browser.findElement(By.id("first_name"));
        WebElement lastName = browser.findElement(By.id("last_name"));

        Random rnd = new Random();
        String random_firstname = "Vorname" + rnd.nextInt(100);
        String random_lastname = "Nachname" + rnd.nextInt(100);

        firstName.clear();
        firstName.sendKeys(random_firstname);
        lastName.clear();
        lastName.sendKeys(random_lastname);

        WebElement btnSave = browser.findElement(By.id("SAVE"));
        btnSave.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full_name")));
        WebElement fullName = browser.findElement(By.id("full_name"));
        assertTrue(fullName.getText().contains(random_firstname) && fullName.getText().contains(random_lastname));

        WebElement actions = browser.findElement(By.linkText("ACTIONS"));
        actions.click();
        WebElement delete = browser.findElement(By.id("delete_button"));
        delete.click();

        browser.switchTo().alert().accept();

    }

    @AfterAll
    public static void closeBrowser() {
        browser.close();
    }

}
