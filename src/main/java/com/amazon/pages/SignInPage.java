package com.amazon.pages;

import com.amazon.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.charset.StandardCharsets;

public class SignInPage extends Basepage {

    // WebElements for SignIn Page
    @FindBy(xpath = "//h1[contains(text(), 'Sign in')]")
    private WebElement signInText;

    @FindBy(xpath = "//*[contains(text(), 'Email or mobile phone number')]")
    private WebElement emailOrMobilePhoneNumberText;

    @FindBy(id = "ap_email")
    private WebElement emailInputBox;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "legalTextRow")
    private WebElement conditionsAndPrivacyMessage;

    @FindBy(className = "a-expander-prompt")
    private WebElement needHelp;

    @FindBy(id = "createAccountSubmit")
    private WebElement createAccountButton;

    @FindBy(id = "ap_password")
    private WebElement passwordInputBox;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(id = "auth-link-bottom")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[contains(text(),'We cannot find an account with that email address')]")
    private WebElement unregisteredEmail;

    @FindBy(xpath = "//div[contains(text(),'Invalid email address or Invalid mobile number.')]")
    private WebElement invalidEmail;
    private String[] fieldName;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Getter Methods
    public WebElement getSignInText() {
        wait.waitForVisibilityOfElement(signInText);
        return signInText;
    }

    public WebElement getEmailOrMobilePhoneNumberText() {
        wait.waitForVisibilityOfElement(emailOrMobilePhoneNumberText);
        return emailOrMobilePhoneNumberText;
    }

    public WebElement getEmailInputBox() {
        wait.waitForVisibilityOfElement(emailInputBox);
        return emailInputBox;
    }

    public WebElement getContinueButton() {
        wait.waitForVisibilityOfElement(continueButton);
        return continueButton;
    }

    public WebElement getConditionsAndPrivacyMessage() {
        wait.waitForVisibilityOfElement(conditionsAndPrivacyMessage);
        return conditionsAndPrivacyMessage;
    }

    public WebElement getNeedHelp() {
        wait.waitForVisibilityOfElement(needHelp);
        return needHelp;
    }

    public WebElement getCreateAccountButton() {
        wait.waitForVisibilityOfElement(createAccountButton);
        return createAccountButton;
    }

    public WebElement getPasswordInputBox() {
        wait.waitForVisibilityOfElement(passwordInputBox);
        return passwordInputBox;
    }

    public WebElement getSignInButton() {
        wait.waitForVisibilityOfElement(signInButton);
        return signInButton;
    }

    public WebElement getForgotPasswordLink() {
        wait.waitForVisibilityOfElement(forgotPasswordLink);
        return forgotPasswordLink;
    }

    public WebElement getUnregisteredEmailError() {
        wait.waitForVisibilityOfElement(unregisteredEmail);
        return unregisteredEmail;
    }

    public WebElement getInvalidEmailError() {
        wait.waitForVisibilityOfElement(invalidEmail);
        return invalidEmail;
    }

    // Page Actions
    public void enterEmailId(String email) {
        getEmailInputBox().sendKeys(email);
    }

    public void clickOnContinueButton() {
        getContinueButton().click();
    }

    public String readUnregisteredEmailIdError() {
        return getUnregisteredEmailError().getText();
    }

    public String readInvalidEmailIdError() {
        return getInvalidEmailError().getText();
    }

    public void enterPassword(String password) {
        getPasswordInputBox().sendKeys(password);
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

//    public void setupCorrectRegistrationPage(){
//        getCorrectRegistrationPage().click();
//    }

    public void signInWithValidCredentials(String validEmail, String validPassword) {
        enterEmailId(validEmail);
        clickOnContinueButton();
        enterPassword(validPassword);
        clickSignInButton();
    }

    public boolean verifyPresenceOfElementsOnPage() {
        boolean result = true;
        int count = 0;

        for (String fieldName : fieldName) {
            WebElement element = getElementByFieldName(fieldName);

            if (element == null) {
                System.out.println("No WebElement mapped for: " + fieldName);
                result = false;
                count++;
                continue;
            }

            if (element.isDisplayed()) {
                System.out.println(fieldName + " is present on the page.");
            } else {
                System.out.println(fieldName + " is NOT present on the page.");
                result = false;
                count++;
            }
        }

        return count == 0;
    }

    private WebElement getElementByFieldName(String fieldName) {
        switch (fieldName.toLowerCase().trim()) {
            case "sign in":
                return getSignInText();
            case "email or mobile phone number":
                return getEmailOrMobilePhoneNumberText();
            case "email input box":
                return getEmailInputBox();
            case "continue button":
                return getContinueButton();
            case "conditions and privacy":
                return getConditionsAndPrivacyMessage();
            case "need help":
                return getNeedHelp();
            case "create account":
                return getCreateAccountButton();
            case "password":
                return getPasswordInputBox();
            case "sign in button":
                return getSignInButton();
            case "forgot password":
                return getForgotPasswordLink();
            default:
                return null;
        }
    }

    public byte[] readUnregisterEmailIdError() {
        String errorMessage = getUnregisteredEmailError().getText();
        return errorMessage.getBytes(StandardCharsets.UTF_8);
    }


}
