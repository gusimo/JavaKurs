package com.codeflix.selenium;

import com.codeflix.selenium.pageObjects.LeadPage;
import com.codeflix.selenium.pageObjects.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

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
    public void loginNegative(){
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("gsimon", "NÖÖÖ");
    }

    @Test
    @Order(2)
    public void login(){
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("gsimon", "LiM#m0cS");
    }

    @Test
    @Order(10)
    public void createLead(TestReporter reporter) {
        LeadPage leadPage = new LeadPage(browser);

        Random rnd = new Random();
        String random_firstname = "Vorname" + rnd.nextInt(100);
        String random_lastname = "Nachname" + rnd.nextInt(100);

        leadPage.CreateLead(random_firstname, random_lastname);
        leadPage.deleteLead();
    }

    @AfterAll
    public static void closeBrowser() {
        browser.close();
    }

}
