package com.amazon.customlisteners;

import com.amazon.basetest.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyListener extends BaseTest implements ITestListener, IAnnotationTransformer {
    //IAnnotationTransformer = implement transform method to set RetryAnalyzer class
    //Add Listener info in the XML file

    @Override
    public void onTestStart(ITestResult result){
        //use this method to perform some action when test is start
        System.out.println("*********Staring Test******* Test Name ==> " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        //use this method to perform some action when test is failed
        //Ex- take the webpage screenshot
        System.out.println("*********Test Failed******* Test Name ==> " + result.getName());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String dynamicScreenshotName = result.getName()+formatter.format(now);
        File fIn = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(fIn,new File(System.getProperty("user.dir")+".src/test/java/resource/Screenshots/"+dynamicScreenshotName+".png"));
        }catch (IOException io){
            io.printStackTrace();
        }


    }
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
        annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
    }
}
