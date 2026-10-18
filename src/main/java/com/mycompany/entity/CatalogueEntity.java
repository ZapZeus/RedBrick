/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

import com.mycompany.enums.CatagoryEnum;
import com.mycompany.enums.MediaTypeEnum;

/**
 *This is to for a book within the application
 * creates the objects information such as title,isbn and whatever
 * 
 * 
 * @author m2505660
 */
public class CatalogueEntity {
    private String isbn;
    private String author;
    private String title;
    private MediaTypeEnum mediaType;
    private CatagoryEnum catagory;

    public CatalogueEntity(String isbn, String Author, String title, MediaTypeEnum mediaType, CatagoryEnum catagory) {
        this.isbn = isbn;
        this.author = Author;
        this.title = title;
        this.mediaType = mediaType;
        this.catagory = catagory;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public MediaTypeEnum getMediaType() {
        return mediaType;
    }
    
    public CatagoryEnum getCatagory(){
        return catagory;
    }


    
}
