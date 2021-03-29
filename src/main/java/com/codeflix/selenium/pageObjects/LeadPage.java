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

    private By createButtonBy = By.xpath("//a[@data-action-name='Create']");
    private By firstNameBy =    By.id("first_name");
    private By lastNameBy =     By.id("last_name");
    private By btnSaveBy =      By.id("SAVE");
    private By fullNameBy =     By.id("full_name");
    private By btnActionsBy =   By.linkText("ACTIONS");
    private By btnDeleteBy =    By.id("delete_button");

    public void CreateLead(String firstName, String lastName) {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createButtonBy));

        WebElement createButton = browser.findElement(createButtonBy);
        createButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameBy));
        WebElement firstNameElement = browser.findElement(firstNameBy);
        WebElement lastNameElement = browser.findElement(lastNameBy);

        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);

        WebElement btnSaveElement = browser.findElement(btnSaveBy);
        btnSaveElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameBy));
        WebElement fullName = browser.findElement(fullNameBy);
        assertTrue(fullName.getText().contains(firstName) && fullName.getText().contains(lastName));
    }

    public void deleteLead(){
        WebElement actions = browser.findElement(btnActionsBy);
        actions.click();
        WebElement delete = browser.findElement(btnDeleteBy);
        delete.click();

        browser.switchTo().alert().accept();
    }

}
