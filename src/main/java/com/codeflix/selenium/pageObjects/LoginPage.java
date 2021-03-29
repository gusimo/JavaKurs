package com.codeflix.selenium.pageObjects;

import org.junit.jupiter.api.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private String url = "http://crm.hiq.de";
    private WebDriver browser;

    public LoginPage(WebDriver currentBrowser) {
        browser = currentBrowser;
        browser.get(url);
    }

    public void Login(String userName, String password) {
        WebElement usernameElement = browser.findElement(By.id("user_name"));
        usernameElement.clear();
        usernameElement.sendKeys(userName);

        WebElement passwordElement = browser.findElement(By.id("username_password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement loginbuttonElement = browser.findElement(By.id("bigbutton"));
        loginbuttonElement.click();
    }

}
