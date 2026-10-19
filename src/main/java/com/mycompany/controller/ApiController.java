/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import Util.JsonHandlerUtil;
import com.mycompany.repository.CatalogueRepository;
import com.mycompany.repository.CatalogueRepositoryImpl;
import com.mycompany.repository.MemberRepository;
import com.mycompany.repository.MemberRepositoryImpl;
import com.mycompany.services.CatalogueService;
import com.mycompany.services.MemberService;
import com.sun.net.httpserver.HttpServer;
import java.sql.SQLException;

/**
 *This handles api requests and retrieves info for the relevent endpoint.
 * @author parks
 */
public class ApiController {
    
    private final CatalogueService catalogueService;

    private final MemberService memberService;

    public ApiController() {
        
        CatalogueRepository catalogueRepository = new CatalogueRepositoryImpl();
        this.catalogueService = new CatalogueService(catalogueRepository);
        
        MemberRepository repository = new MemberRepositoryImpl();
        this.memberService = new MemberService(repository);
    }

    public void registerRoutes(HttpServer server) {

        // Return all members as JSON
        server.createContext("/api/members", exchange -> {

            try {
                if (!exchange.getRequestMethod().equals("GET")) {
                    exchange.getResponseHeaders().set("Allow", "GET");

                    JsonHandlerUtil.sendJson(
                            exchange, 405, "Method not allowed"
                    );
                    return;
                }

                JsonHandlerUtil.sendJson(
                        exchange, 200, memberService.getMemberDtos()
                );

            } catch (SQLException e) {
                JsonHandlerUtil.sendJson(
                        exchange, 500, "Unable to retrieve members"
                );
            }
        });
        
        server.createContext("/api/admin/members", exchange -> {
            try{
                if(!exchange.getRequestMethod().equals("GET")){
                    exchange.getResponseHeaders().set("Allow", "GET");
                    
                    JsonHandlerUtil.sendJson(exchange, 405, "Method not allowed");
                    return;
                }
                JsonHandlerUtil.sendJson(exchange, 200, memberService.getAllMemberDtos());
            }
            catch (SQLException e){
                JsonHandlerUtil.sendJson(exchange, 500, "Unable to retrieve accounts");
            }
        });
        
        server.createContext("/api/catalogue",exchange -> {
            try{
                if(!exchange.getRequestMethod().equals("GET")){
                    exchange.getResponseHeaders().set("Allow","GET");
                    
                    JsonHandlerUtil.sendJson(exchange,405,"Method not allowed");
                    return;
                }
                JsonHandlerUtil.sendJson(exchange, 200, catalogueService.findAllBooks());
            }
            catch (SQLException e){
                JsonHandlerUtil.sendJson(exchange, 500, "Unable to retrieve book");
            }
        });
    }
    

}
