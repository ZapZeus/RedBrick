/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Defines the contract for obtaining a database connection.
 *
 * @author parks
 */
public interface DatabaseConnection {

    Connection getConnection() throws SQLException;
}