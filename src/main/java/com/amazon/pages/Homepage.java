package com.amazon.pages;

import com.amazon.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {

    private Actions action;

    @FindBy(id = "nav-link-accountList")
    public WebElement accountsAndLists;

    @FindBy(xpath = "//div[@id='nav-flyout-signin']//span[text()=Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@id='nav-flyout-signin']//span[text()=Start here']")
    public WebElement newCustomerStartHere;

    public Homepage(WebDriver driver) { // coustructor
        super(driver);
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    //open the registration page
    public void openRegistrationPage() {
        //this open RegistrationPage page action as amethod in my homepage class
        //method name start with the lower case
        //this method call from registration test page
        action.moveToElement(getAccountsAndListsElement()).build().perform();
        getStartHereElement().click();

    }

    public void openSignInPage() {
        action.moveToElement(getAccountsAndListsElement()).perform();
        getSignInButtonElement().click();
    }

    public String getTitleOfThePage() {
        return null;
    }
    //GETTER method for the WebElement

    public WebElement getAccountsAndListsElement() {
        wait.waitForVisibilityOfElement(accountsAndLists);
        return accountsAndLists;
    }

    public WebElement getStartHereElement() {
        wait.waitForVisibilityOfElement(newCustomerStartHere);
        return newCustomerStartHere;

    }

    public WebElement getSignInButtonElement() {
        wait.waitForVisibilityOfElement(signInButton);
        return signInButton;


    }
}
