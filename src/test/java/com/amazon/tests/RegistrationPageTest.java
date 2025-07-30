package com.amazon.tests;

import com.amazon.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegistrationPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setupPage() {
        // Open the registration page from the homepage
        homepage.openRegistrationPage();
        registrationPage.setupCorrectRegistrationPage();
    }


    @Test(groups = {" sanity"})
    public void isLogoPresentTest() {
        Assert.assertTrue(registrationPage.verifyLogo(), "ERROR - Logo is not present on the registration page.");
    }
}

//    @Test(groups = {" sanity"})
//    public void pageTitleTest() {
//        String actualTitle = registrationPage.getTitleOfThePage();
//        Assert.assertEquals(actualTitle, "Amazon Registration",
//                "ERROR - Page title mismatch. Expected: 'Amazon Registration' | Actual: '" + actualTitle + "'");
//    }
//
//
//    @Test(groups = {" regression"})
//    public void signInLinkTest() {
//        registrationPage.clickOnSignInLink();
//
//        String actualTitle = signInPage.getTitleOfThePage();
//        Assert.assertEquals(actualTitle, "Amazon sign in page open",
//                "ERROR - Sign in page title mismatch. Actual Title: " + actualTitle);
//
//        Assert.assertTrue(signInPage.getSignInText().isDisplayed(),
//                "ERROR - Sign in text is not displayed after clicking on sign in link.");
//    }
//
//    @Test(groups = {" regression"})
//    public void createBusinessAccountTest() {
//        registrationPage.clickOnCreateBusinessAccountLink();
//
//        String actualTitle = businessPage.getTitleOfThePage();
//        Assert.assertEquals(actualTitle, "Amazon Business",
//                "ERROR - Amazon Business page did not open after clicking the business account link.");
//    }
//
//    @Test(groups = {" sanity"})
//    public void fieldsOnThePageTest() throws IOException {
//        List<String> fieldNames = excelReader.getFieldNamesFromExcel("RegistrationPage");
//
//        boolean result = registrationPage.verifyPresenceOfElementsOnPage(fieldNames);
//        Assert.assertTrue(result, "ERROR - Some elements are not present on the registration page as expected.");
//    }
//}
