package com.librarymanagement.bdd.config;

import com.librarymanagement.bdd.constants.Constants;
import com.librarymanagement.bdd.utils.PropertiesFileReader;

public class Configuration {

    private static final PropertiesFileReader propertiesFileReader = new PropertiesFileReader(Constants.configPropertyFile);

    public static String getJdbcUrl() {
        return propertiesFileReader.getValue("jdbcUrl");
    }

    public static String getBaseUrl() {
        return propertiesFileReader.getValue("baseUrl");
    }

    public static String getUserName() {
        return propertiesFileReader.getValue("userName");
    }

    public static String getPassword() {
        return propertiesFileReader.getValue("password");
    }

    public static String getClientId() {
        return propertiesFileReader.getValue("clientId");
    }

    public static String getClientSecret() {
        return propertiesFileReader.getValue("clientSecret");
    }

    public static String getStudentClientId() {
        return propertiesFileReader.getValue("clientIdStudent");
    }

    public static String getStudentClientSecret() {
        return propertiesFileReader.getValue("clientSecretStudent");
    }
}
