package com.amazon.customlisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
     //Implement retry method to rerun the failed tests for given count automatically

    private int retryCount = 0;
    private int max_retryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < max_retryCount && !result.isSuccess()){
            retryCount++;
            System.out.println("Retrying the Test ==> " + result.getName()+ " ==> Attempt No = " + retryCount);
            return true;
        }
        return false;
    }
}
