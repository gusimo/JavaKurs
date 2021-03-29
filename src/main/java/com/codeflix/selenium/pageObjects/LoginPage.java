package com.codeflix.selenium.pageObjects;

import org.junit.jupiter.api.TestReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPage {

    private String url = "http://crm.hiq.de";
    private WebDriver browser;

    public LoginPage(WebDriver currentBrowser) {
        browser = currentBrowser;
        browser.get(url);
    }

    private void enterLoginData(String userName, String password) {
        WebElement usernameElement = browser.findElement(By.id("user_name"));
        usernameElement.clear();
        usernameElement.sendKeys(userName);

        WebElement passwordElement = browser.findElement(By.id("username_password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement loginbuttonElement = browser.findElement(By.id("bigbutton"));
        loginbuttonElement.click();
    }

    public void login(String userName, String password) {
        enterLoginData(userName, password);
    }

    public void loginNegative(String userName, String password) {
        enterLoginData(userName, password);
        WebElement error = browser.findElement(By.xpath("//span[contains(text(),'You must specify a valid username and password.')]"));
        assertNotNull(error, "Error message was not found");
    }

}
