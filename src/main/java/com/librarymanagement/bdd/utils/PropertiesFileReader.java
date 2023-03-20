package com.librarymanagement.bdd.utils;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class PropertiesFileReader {

    private FileReader fileReader;
    private Properties properties;

    public PropertiesFileReader(String filePath) {
        try {
            fileReader = new FileReader(filePath);
            properties = new Properties();
            properties.load(fileReader);
            log.info("File successfully loaded located at : {}", filePath);
        } catch (Exception e) {
            log.error("Error occurred while loading the property file with error message : {}", e.getMessage());
        }
    }

    /**
     * Fetch the value from property file
     *
     * @param key Key to get value
     * @return Value of the key
     */
    public String getValue(String key) {
        if (!Objects.isNull(properties)) {
            Assert.assertNotNull(key, "Key can not be null or empty");
            return properties.getProperty(key, "");
        } else {
            return "";
        }
    }

}
