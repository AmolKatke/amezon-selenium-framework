package com.amazon.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {

    private WebDriver driver;
    private WebDriverWait wait;

    //Cerate a constructor for this class is call ehile creating the object for this custoom wait
    //object create in a base page base page is parenti
    //if you create object in base class that will applicable for all apllication
    public CustomWait(WebDriver driver, Duration timeout){

        this.driver = this.driver; //from base class
        this.wait= new WebDriverWait(driver,timeout);
    }

    //Method //wait for an Element to be visible *1st
    public void waitForVisibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            //e.printStackTrace(); // print in cosole
            setElementPresentState(false);
            System.err.println("Element is not visible after waiting :  " +e.getMessage());
        }
    }

    //wait for Element to be clickable
    public void waitForElementToBeClickable(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException e){
            System.err.println("Element is not Clickable after waiting : " + e.getMessage());
        }
    }

    //wait for an element to be invisible
    public void waitForElementToBeInvisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            System.err.println("Element is not invisible after waiting : " + e.getMessage());
        }
    }
    private void  setElementPresentState(boolean state){
        boolean elementState = state;
    }
//    public boolean getElementPresentState(){
//        boolean elementState;
//        return elementState;
//
//    }

}