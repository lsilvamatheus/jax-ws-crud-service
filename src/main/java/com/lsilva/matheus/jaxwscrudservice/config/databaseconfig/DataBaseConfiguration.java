package com.lsilva.matheus.jaxwscrudservice.config.databaseconfig;

import com.lsilva.matheus.jaxwscrudservice.utils.PropertiesUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConfiguration {

    private DataBaseConfiguration() {}

    private static Connection connection = null;
    private static final String DATABASE_URL_PROPERTY = "dataBaseUrl";

    public static Connection getConnection(){
        return createConnection();
    }
    private static Connection createConnection() {
        if (connection == null) {
            try {
                Properties properties = PropertiesUtils.loadProperties();
                String url = properties.getProperty(DATABASE_URL_PROPERTY);
                connection = DriverManager.getConnection(url, properties);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

}
