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

    private By txtUserNameBy = By.id("user_name");
    private By txtPasswordBy = By.id("username_password");
    private By btnLoginBy = By.id("bigbutton");
    private By txtLoginErrorBy = By.xpath("//span[contains(text(),'You must specify a valid username and password.')]");

    private void enterLoginData(String userName, String password) {
        WebElement usernameElement = browser.findElement(txtUserNameBy);
        usernameElement.clear();
        usernameElement.sendKeys(userName);

        WebElement passwordElement = browser.findElement(txtPasswordBy);
        passwordElement.clear();
        passwordElement.sendKeys(password);

        browser.findElement(btnLoginBy).click();
    }

    public void login(String userName, String password) {
        enterLoginData(userName, password);
    }

    public void loginNegative(String userName, String password) {
        enterLoginData(userName, password);
        WebElement error = browser.findElement(txtLoginErrorBy);
        assertNotNull(error, "Error message was not found");
    }

}
