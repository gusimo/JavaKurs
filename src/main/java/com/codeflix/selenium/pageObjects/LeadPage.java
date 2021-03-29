package com.codeflix.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeadPage {

    private String url = "http://crm.hiq.de/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Dindex%26parentTab%3DMarketing";
    private WebDriver browser;

    public LeadPage(WebDriver currentBrowser) {
        browser = currentBrowser;
        browser.get(url);
    }

    public void CreateLead(String firstName, String lastName) {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-action-name='Create']")));

        WebElement createButton = browser.findElement(By.xpath("//a[@data-action-name='Create']"));
        createButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
        WebElement firstNameElement = browser.findElement(By.id("first_name"));
        WebElement lastNameElement = browser.findElement(By.id("last_name"));

        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

        WebElement btnSaveElement = browser.findElement(By.id("SAVE"));
        btnSaveElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full_name")));
        WebElement fullName = browser.findElement(By.id("full_name"));
        assertTrue(fullName.getText().contains(firstName) && fullName.getText().contains(lastName));

    }

    public void deleteLead(){
        WebElement actions = browser.findElement(By.linkText("ACTIONS"));
        actions.click();
        WebElement delete = browser.findElement(By.id("delete_button"));
        delete.click();

        browser.switchTo().alert().accept();
    }

}
