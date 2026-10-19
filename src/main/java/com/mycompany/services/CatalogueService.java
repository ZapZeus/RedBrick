/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entity.CatalogueEntity;
import com.mycompany.repository.CatalogueRepository;
import java.sql.SQLException;

/**
 *this should contain the service or logic for the books
 * this is the middleman for the book controller and the book repo
 * @author m2505660
 */
public class CatalogueService {
    
    private final CatalogueRepository repository;

    public CatalogueService(CatalogueRepository repository) {
        this.repository = repository;
    }

    public CatalogueEntity findFirstBook() throws SQLException {
        return repository.findFirstBook();
    }
    
    
}
