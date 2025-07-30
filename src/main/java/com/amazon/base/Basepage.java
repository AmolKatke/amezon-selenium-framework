package com.amazon.base;

import com.amazon.utils.ConfigReader;
import com.amazon.utils.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Basepage {

    protected WebDriver driver;
    protected CustomWait wait;
    protected ConfigReader configReader;

    //web Element got logo
    @FindBy(xpath = "//i[@aria-label='Amazon']")
    private WebElement logo;


    // costructor - inheritance

    public Basepage(WebDriver driver) {
        this.driver=driver;
        configReader =new ConfigReader();
        PageFactory.initElements(driver,this);
        this.wait = new CustomWait(driver, Duration.ofSeconds(configReader.getGlobalWaitValue()));
    }

    public WebDriver getDriver(String browser){
         if (browser.equalsIgnoreCase("chrome")) {
             ChromeOptions options = new ChromeOptions(); //for Incognito mode//
             options.addArguments("--incognito");
             driver = new ChromeDriver();
             driver.manage().window().maximize();
         } else if (browser.equalsIgnoreCase("firefox")) {
             driver= new FirefoxDriver();
         } else {
             driver=new EdgeDriver();
         }
      return  driver;
    }
//Getter Method//

    public WebElement getLogo(){
        wait.waitForVisibilityOfElement(logo);
        return logo;
    }
    public void quitDriver(){
        driver.quit();
    }
    //common method
    //logo

       public boolean verifyLogo(){
       return getLogo().isDisplayed();
    }
//verify tittle
       public String getTitleOfThePage(){
       return driver.getTitle();
    }
//currentURL
       public String getCurrentPageUrl() {
       return driver.getCurrentUrl();
   }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
         driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
