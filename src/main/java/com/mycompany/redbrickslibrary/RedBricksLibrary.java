/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.redbrickslibrary;

import com.mycompany.entity.CatalogueEntity;
import com.mycompany.repository.CatalogueRepository;
import com.mycompany.repository.CatalogueRepositoryImpl;

/**
 * This is the main boyo.
 *
 * @author m2505660
 */
public class RedBricksLibrary {

    public static void main(String[] args) throws Exception {
        new Application().start();
        
                // Testing our catalogue repository
        CatalogueRepository catrepo = new CatalogueRepositoryImpl();

        CatalogueEntity book = catrepo.findFirstBook();

        if (book != null) {

            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("TITLE: " + book.getTitle());
            System.out.println("AUTHOR: " + book.getAuthor());
            System.out.println("MEDIA: " + book.getMediaType());
            System.out.println("CATEGORY: " + book.getCatagory());

        } else {

            System.out.println("NO BOOKS FOUND");

        }
    }

    }
