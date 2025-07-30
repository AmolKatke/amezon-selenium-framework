package com.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/configurations/config.properties")) {
            prop.load(fis);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("URL");
    }

    public String getBrowser() {
        return prop.getProperty("BROWSER");
    }

    public long getGlobalWaitValue() {
        String value = prop.getProperty("GLOBALWAIT");
        if (value == null) {
            throw new IllegalArgumentException("GLOBALWAIT property is missing");
        }
        return Long.parseLong(value);
    }

    public String getFieldsVerificationExcelName() {
        return prop.getProperty("FIELDS_VERIFICATION_EXCEL");
    }
}