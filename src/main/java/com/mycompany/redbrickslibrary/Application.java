/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redbrickslibrary;

import com.mycompany.controller.ApiController;
import com.mycompany.controller.WebController;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author parks
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void start() throws IOException, SQLException {

        HttpServer server
                = HttpServer.create(new InetSocketAddress(8081), 0);

        // Create WebController
        WebController webController = new WebController();
        webController.registerRoutes(server);

        ApiController apiController = new ApiController();
        apiController.registerRoutes(server);

        // Start the server
        server.start();

        LOGGER.info("Server started on http://localhost:8081");
    }
}
