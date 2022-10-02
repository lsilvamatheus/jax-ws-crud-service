package com.lsilva.matheus.jaxwscrudservice;

import com.lsilva.matheus.jaxwscrudservice.service.NoticiaSIB;
import com.lsilva.matheus.jaxwscrudservice.utils.PropertiesUtils;
import jakarta.xml.ws.Endpoint;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        BasicConfigurator.configure();
        logger.info("publicando serviço.");
        Endpoint.publish(PropertiesUtils.getApplicationAddress(), new NoticiaSIB());
        logger.info("serviço publicado.");
    }
}