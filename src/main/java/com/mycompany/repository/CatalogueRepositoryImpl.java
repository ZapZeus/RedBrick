/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.entity.CatalogueEntity;
import com.mycompany.enums.CatagoryEnum;
import com.mycompany.enums.MediaTypeEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author parks
 */
public class CatalogueRepositoryImpl implements CatalogueRepository {
    private final DatabaseConnectionImpl database = new DatabaseConnectionImpl();
    
    @Override
    public CatalogueEntity findFirstBook() throws SQLException{
        String sql = "SELECT * FROM book_catalogue ORDER BY title LIMIT 1";
        
        try(Connection connection = database.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery()){
            
            if (results.next()){
                return new CatalogueEntity(
                results.getString("isbn"),
                results.getString("author"),
                results.getString("title"),
                MediaTypeEnum.valueOf(results.getString("media_type")),
                CatagoryEnum.valueOf(results.getString("category")));
            }
        }
        return null;
    }
}
