package com.lsilva.matheus;

import com.lsilva.matheus.databaseconfig.DataBaseConfiguration;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        BasicConfigurator.configure();

        logger.info("Conectando a base de dados");
        Connection connection = DataBaseConfiguration.getConnection();
        logger.error("conexão:" + connection.getCatalog());

        logger.info("Hello world!");
    }
}