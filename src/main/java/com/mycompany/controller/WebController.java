/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.repository.MemberRepository;
import com.mycompany.repository.MemberRepositoryImpl;
import com.mycompany.services.MemberService;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This does all the websitey bits it handles website routes and keeps website
 * nav seperate from the api requests.
 *
 * @author m2505660
 */
public class WebController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(WebController.class);

    private final MemberService memberService;

    public WebController() {
        MemberRepository memberrepository = new MemberRepositoryImpl();
        this.memberService = new MemberService(memberrepository);
    }

    public void registerRoutes(HttpServer server) {

        // Home page
        server.createContext("/", exchange -> {
            serveFile(exchange, "/views/index.html", "text/html");
        });

        // Books page dont know whats going on here yet...
        server.createContext("/catalogue", exchange -> {
            serveFile(exchange, "/views/catalogue.html", "text/html");
        });

        // for the user, hopefully multiple but we'll see what happens
        server.createContext("/members", exchange -> {
            serveFile(exchange, "/views/members.html", "text/html");
        });

        // this is for the admin, although i dont know if this is right because of my admin log on but it works so dont change it.
        server.createContext("/admin", exchange -> {
            serveFile(exchange, "/views/admin.html", "text/html");
        });

        //theres so many more pages to add
        // this one is for a single member when i get the database loaded with the members in and if i remember.
        server.createContext("/member", exchange -> {
            serveFile(exchange, "/views/member.html", "text/html");
        });

        // admin catalogue management system
        server.createContext("/admin/catalogue", exchange -> {
            serveFile(exchange, "/views/admin-catalogue.html", "text/html");
        });

        // a bunch more admin stuff will follow this one is member management
        server.createContext("/admin/members", exchange -> {
            serveFile(exchange, "/views/admin-members.html", "text/html");
        });

        //admin reservations
        server.createContext("/admin/reservations", exchange -> {
            serveFile(exchange, "/views/admin-reservations.html", "text/html");
        });

        // admin loans
        server.createContext("/admin/loans", exchange -> {
            serveFile(exchange, "/views/admin-loans.html", "text/html");
        });

        // the annoying CSS but it works so dont look at it.
        server.createContext("/style.css", exchange -> {
            serveFile(exchange, "/views/style.css", "text/css");
        });

// Minecraft backgrounds and navigation buttons, where are the images....here they are...
        String[] images = {
            "index.png",
            "catalogue.png",
            "admin.png",
            "members.png",
            "admin-members.png",
            "admin-catalogue.png",
            "admin-loans.png",
            "admin-reservations.png",
            "home_button.png",
            "catalogue_button.png",
            "members_button.png",
            "admin_button.png",
            "browsebooks_button.png",
            "logout.png",
            "loans_button.png",
            "reservation_button.png"
        };

        for (String image : images) {
            server.createContext("/images/" + image, exchange -> {
                serveFile(
                        exchange,
                        "/views/images/" + image,
                        "image/png"
                );
            });
        }

    }

    /**
     * takes it from resources and pops in on the browser.
     */
    private void serveFile(
            com.sun.net.httpserver.HttpExchange exchange,
            String filePath,
            String contentType) throws IOException {

        InputStream file = WebController.class
                .getResourceAsStream(filePath);

        if (file == null) {

            LOGGER.error("File not found: {}", filePath);

            String response = "File not found";

            exchange.sendResponseHeaders(
                    404,
                    response.getBytes().length
            );

            exchange.getResponseBody().write(
                    response.getBytes()
            );

        } else {

            LOGGER.info("Serving: {}", filePath);

            byte[] response = file.readAllBytes();

            exchange.getResponseHeaders().set(
                    "Content-Type",
                    contentType + "; charset=UTF-8"
            );

            exchange.sendResponseHeaders(
                    200,
                    response.length
            );

            exchange.getResponseBody().write(response);
        }

        exchange.getResponseBody().close();
    }
}
