/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

import com.mycompany.enums.MediaTypeEnum;

/**
 *This is to for a book within the application
 * creates the objects information such as title,isbn and whatever
 * 
 * 
 * @author m2505660
 */
public class CatalogueEntity {
    private int isbn;
    private String Author;
    private String title;
    private MediaTypeEnum mediaType;

    public CatalogueEntity(int isbn, String Author, String title, MediaTypeEnum mediaType) {
        this.isbn = isbn;
        this.Author = Author;
        this.title = title;
        this.mediaType = mediaType;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return title;
    }

    public MediaTypeEnum getMediaType() {
        return mediaType;
    }


    
}
