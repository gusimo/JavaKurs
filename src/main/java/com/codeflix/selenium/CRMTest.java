package com.codeflix.selenium;

import com.codeflix.selenium.pageObjects.LeadPage;
import com.codeflix.selenium.pageObjects.LoginPage;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


import java.util.Random;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class CRMTest {

    @Test
    @Order(1)
    public void loginNegative(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginNegative("gsimon", "NÖÖÖ");
    }

    @Test
    @Order(2)
    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("gsimon", "LiM#m0cS");
    }

    @Test
    @Order(10)
    public void createLead(TestReporter reporter) {
        LeadPage leadPage = new LeadPage();

        Random rnd = new Random();
        String random_firstname = "Vorname" + rnd.nextInt(100);
        String random_lastname = "Nachname" + rnd.nextInt(100);

        leadPage.CreateLead(random_firstname, random_lastname);
        leadPage.deleteLead();
    }

    @AfterAll
    public static void closeBrowser() {
        closeWebDriver();
    }

}
