package com.amazon.tests;

import com.amazon.basetest.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInPageTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public  void setupPage(){

        //open the signIN page from home pgae of amazon
        homepage.openSignInPage();
    }

    //verify_Logo
    @Test(groups = { " sanity" })
    //Run | Debug
    public void isLogoPresentTest(){
        Assert.assertTrue(signInPage.verifyLogo(),"Error - Logo not present on Amazon site");

    }
    //verify_Page_Title
    @Test(groups = { " sanity" })
    //Run | Debug
    public void PageTitleTest(){
        Assert.assertEquals(signInPage.getTitleOfThePage(),"Amazon sign In","Error - Sign in title not present");
    }
    /* Verify back and forth scenarios
    navigate back and verify sign page
    navigate forward and verify sign In page
    refresh the page and verify if we navigate to sign in page
     */
    @Test(groups = { " regression" })
    //Run | Debug

    public void backAndForthScenariosTest(){

        basepage.navigateBack();
        Assert.assertEquals(homepage.getTitleOfThePage(),"Online Shopping site in India: Shop onlline for Mobile,Book,Watches");
        basepage.navigateForward();
        Assert.assertEquals(signInPage.getTitleOfThePage(),"Amezon Sign In");
        basepage.refreshPage();
        Assert.assertEquals(signInPage.getTitleOfThePage(),"Amezon Sign In");
    }
    //sign In With unregistered Email Id
    @Test(groups = { " regression" })
    //Run | Debug
    public void signInWithUnregisteredEmailIdTest(){

        signInPage.enterEmailId("abcdf@test");
        signInPage.clickOnContinueButton();
        //Assert Error

        Assert.assertEquals(signInPage.readUnregisterEmailIdError(),"We cannot found an account with that email address");
    }

    //Sign In With Invalid Email_Id
    @Test(groups = { " regression" })
    //Run | Debug
    public void signInWithInvalidEmailIdTest(){

        signInPage.enterEmailId("abcSrgsd@test.com");
        signInPage.clickOnContinueButton();
        //Assert Error
        Assert.assertEquals(signInPage.readInvalidEmailIdError(),"Wrong or Invalid email Address or Mobile number");
 
    }
    //SignIn With valid EmailId and Pwd
    @Test(groups = { " regression" })
    //Run | Debug
    public void signInWitValidCredentialsTest(){
        signInPage.signInWithValidCredentials("asdas","asdfghjkl");
        //Assert sign in success fill by checking title of page or any element on page
        ////Multiple assertions
    }

    //Verify input fields / fields labels/ links buttons on sign in oage
    @Test(groups = { " sanity" })
    //Run | Debug
     public void fieldsOnThePageTest(boolean result) throws IOException {
        signInPage.verifyPresenceOfElementsOnPage();
         //We can store all the expected fields in Excel and compare actual fields at eun rn time
        // assert all the fields and print  if ant field is not present from the expected list
        Assert.assertTrue(result,"Error - some elements are not present");

    }


}
