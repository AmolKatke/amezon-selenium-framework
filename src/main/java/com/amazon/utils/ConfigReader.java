package com.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    public ConfigReader(){
        prop = new Properties();

        try{
            FileInputStream fis =new FileInputStream("src/test/java/resource/config.properties");
            prop.load(fis);

        }catch (IOException io){
            io.printStackTrace();

        }

    }
    public String getUrl(){
        return prop.getProperty("URL");
    }
    public String getBrowser(){
        return prop.getProperty("BROWSER");
    }

    public long getGlobalWaitValue(){
       return Long.parseLong(prop.getProperty("GLOBALWAIT"));
    }

    public String getFieldsVerificationExcelName(){
        return prop.getProperty("FIELDS_VERIFICATION_EXCEL");
    }
}
