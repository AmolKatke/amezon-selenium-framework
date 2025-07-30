package com.amazon.pages;

import com.amazon.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BusinessPage extends Basepage {
    public BusinessPage(WebDriver driver ){ // coustructor
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
