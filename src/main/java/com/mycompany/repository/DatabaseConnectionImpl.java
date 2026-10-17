/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *Manages connection to database.
 *
 * @author parks
 */
public class DatabaseConnectionImpl implements DatabaseConnection {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DatabaseConnectionImpl.class);

    private static final String URL =
            "jdbc:sqlite:src/main/resources/database/library.db";

    @Override
    public Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(URL);

        LOGGER.info("Successful database connection");

        return connection;
    }
}