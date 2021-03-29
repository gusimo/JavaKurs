package com.codeflix.selenium.pageObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    private String url = "http://crm.hiq.de";

    public LoginPage() {
        open(url);
    }

    private By txtUserNameBy = By.id("user_name");
    private By txtPasswordBy = By.id("username_password");
    private By btnLoginBy = By.id("bigbutton");
    private By txtLoginErrorBy = By.xpath("//span[contains(text(),'You must specify a valid username and password.')]");

    private void enterLoginData(String userName, String password) {
        $(txtUserNameBy).clear();
        $(txtUserNameBy).sendKeys(userName);

        $(txtPasswordBy).clear();
        $(txtPasswordBy).sendKeys(password);

        $(btnLoginBy).click();
    }

    public void login(String userName, String password) {
        enterLoginData(userName, password);
    }

    public void loginNegative(String userName, String password) {
        enterLoginData(userName, password);
        $(txtLoginErrorBy).should(appear);
    }

}
