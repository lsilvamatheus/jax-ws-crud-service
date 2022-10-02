package com.lsilva.matheus.jaxwscrudservice.utils;

import com.lsilva.matheus.jaxwscrudservice.config.databaseconfig.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private PropertiesUtils() {}

    public static final String APPLICATION_ADDRESS_KEY = "endpointPublishAddress";

    public static Properties loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static String getApplicationAddress() {
        return loadProperties().getProperty(APPLICATION_ADDRESS_KEY);
    }
}
