package com.amazon.basetest;

import com.amazon.base.Basepage;
import com.amazon.pages.BusinessPage;
import com.amazon.pages.Homepage;
import com.amazon.pages.RegistrationPage;
import com.amazon.pages.SignInPage;
import com.amazon.testdatareaders.ExcelReader;
import com.amazon.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {

    // Objects
    public Basepage basepage;
    public WebDriver driver;
    public RegistrationPage registrationPage;
    public SignInPage signInPage;
    public Homepage homepage;
    public BusinessPage businessPage;
    public ConfigReader configReader;
    public ExcelReader excelReader;

    @BeforeMethod
    public void baseSetup() {
        configReader = new ConfigReader();

        // ✅ Debug logs to verify config file values
        System.out.println("✅ Browser from config: " + configReader.getBrowser());
        System.out.println("✅ URL from config: " + configReader.getUrl());

        // Initialize driver through Basepage after browser is configured
        basepage = new Basepage(null); // temp null to allow getDriver call
        driver = basepage.getDriver(configReader.getBrowser());

        basepage = new Basepage(driver); // Now re-assign with valid driver
        driver.get(configReader.getUrl());

        // Page Objects Initialization
        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver);
        homepage = new Homepage(driver);
        businessPage = new BusinessPage(driver);

        // Excel Reader Initialization
        String excelPath = Paths.get("src", "test", "resource", "test_data", configReader.getFieldsVerificationExcelName()).toString();
        excelReader = new ExcelReader(excelPath);
    }

    @AfterMethod
    public void closeBrowser() {
        basepage.quitDriver();
    }
}
