package com.amazon.pages;

import com.amazon.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class RegistrationPage extends Basepage {

    @FindBy(id = "ap_phone_number")
    private WebElement mobileNumber;

    @FindBy(id = "ap_customer_name")
    private WebElement yourName;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(xpath = "//a[@id='ra-sign-in-link']")
    private WebElement signInLink;

    @FindBy(xpath = "//h1[contains(text(),'Create Account')]")
    private WebElement createBusinessAccount;

    @FindBy(xpath = "//div[contains(text(),'passwords must be at least')]")
    private WebElement passwordInfoMessage;

    @FindBy(xpath = "//span[contains(text(),'Verify mobile number')]")
    private WebElement verifyMobileNumberButton;

    @FindBy(id = "mobileClaimDisclosureMessageRelaxed")
    private WebElement alreadyHaveAccountText;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Getter Methods
    WebElement getMobileNumber() {
        wait.waitForVisibilityOfElement(mobileNumber);
        return mobileNumber;
    }

    WebElement getYourName() {
        wait.waitForVisibilityOfElement(yourName);
        return yourName;
    }

    WebElement getPassword() {
        wait.waitForVisibilityOfElement(password);
        return password;
    }

    WebElement getCreateBusinessAccount() {
        wait.waitForVisibilityOfElement(createBusinessAccount);
        return createBusinessAccount;
    }

    WebElement getPasswordInfoMessage() {
        wait.waitForVisibilityOfElement(passwordInfoMessage);
        return passwordInfoMessage;
    }

    WebElement getVerifyMobileNumberButton() {
        wait.waitForVisibilityOfElement(verifyMobileNumberButton);
        return verifyMobileNumberButton;
    }

    WebElement getSignInLink() {
        wait.waitForVisibilityOfElement(signInLink);
        return signInLink;
    }

    WebElement getAlreadyHaveAccountText() {
        wait.waitForVisibilityOfElement(alreadyHaveAccountText);
        return alreadyHaveAccountText;
    }

    // Page Actions
    public void enterMobileNumber(String mNumber) {
        getMobileNumber().sendKeys(mNumber);
    }

    public void enterYourName(String name) {
        getYourName().sendKeys(name);
    }

    public void enterYourPassword(String pwd) {
        getPassword().sendKeys(pwd);
    }

    public void clickOnVerifyMobileNumberButton() {
        getVerifyMobileNumberButton().click();
    }

    public void verifyMobileNumberFunctionality(String name, String number, String pwd) {
        enterYourName(name);
        enterMobileNumber(number);
        enterYourPassword(pwd);
        clickOnVerifyMobileNumberButton();
    }

    public void clickOnSignInLink() {
        getSignInLink().click();
    }

    public void clickOnCreateBusinessAccountLink() {
        getCreateBusinessAccount().click();
    }

    public boolean verifyPresenceOfElementsOnPage(List<String> fieldNames) {
        boolean result = true;
        int count = 0;

        for (String fieldName : fieldNames) {
            WebElement element = getElementByFieldName(fieldName);

            if (element == null) {
                System.out.println("Element is null for field: " + fieldName);
                result = false;
                count++;
                continue;
            }

            if (element.isDisplayed()) {
                System.out.println(fieldName + " is present on the page");
            } else {
                System.out.println(fieldName + " is NOT present on the page");
                result = false;
                count++;
            }
        }

        return count == 0;
    }

    private WebElement getElementByFieldName(String fieldName) {
        switch (fieldName.toLowerCase().trim()) {
            case "your name":
                return getYourName();

            case "mobile number":
                return getMobileNumber();

            case "password":
                return getPassword();

            case "verify mobile number button":
                return getVerifyMobileNumberButton();

            case "create business account":
                return getCreateBusinessAccount();

            case "sign in link":
                return getSignInLink();

            case "already have an account":
                return getAlreadyHaveAccountText();

            default:
                System.out.println("Invalid field name: " + fieldName);
                return null;
        }
    }

    public void setupCorrectRegistrationPage() {
        wait.waitForVisibilityOfElement(createBusinessAccount); // Verify "Create Account" header is visible
        String actualTitle = driver.getTitle();
        if (!actualTitle.contains("Amazon Registration")) {
            throw new IllegalStateException("Registration page not loaded correctly. Expected title to contain 'Amazon Registration', but got: " + actualTitle);
        }
    }
}
