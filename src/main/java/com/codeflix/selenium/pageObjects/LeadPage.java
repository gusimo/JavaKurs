package com.codeflix.selenium.pageObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LeadPage {

    private String url = "http://crm.hiq.de/index.php?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Dindex%26parentTab%3DMarketing";

    public LeadPage() {
        open(url);
    }

    private By createButtonBy = By.xpath("//a[@data-action-name='Create']");
    private By firstNameBy =    By.id("first_name");
    private By lastNameBy =     By.id("last_name");
    private By btnSaveBy =      By.id("SAVE");
    private By fullNameBy =     By.id("full_name");
    private By btnActionsBy =   By.linkText("ACTIONS");
    private By btnDeleteBy =    By.id("delete_button");

    public void CreateLead(String firstName, String lastName) {
        $(createButtonBy).should(appear);
        $(createButtonBy).click();

        $(firstNameBy).should(appear);
        $(firstNameBy).clear();
        $(lastNameBy).clear();

        $(firstNameBy).sendKeys(firstName);
        $(lastNameBy).sendKeys(lastName);

        $(btnSaveBy).click();

        $(fullNameBy).should(appear);
        $(fullNameBy).should(have(text(firstName)));
        $(fullNameBy).should(have(text(lastName)));
    }

    public void deleteLead(){
        $(btnActionsBy).click();
        $(btnDeleteBy).click();
        confirm();
    }

}
