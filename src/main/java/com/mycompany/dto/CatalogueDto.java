/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto;

import com.mycompany.enums.MediaTypeEnum;

/**
 *DTO is data transfer object so this is used to transfer data about books between 
 * different parts of the application.
 * @author m2505660
 */
public class CatalogueDto {
    private String isbn;
    private String author;
    private String title;
    private MediaTypeEnum mediaType;

    public CatalogueDto(String isbn, String author, String title, MediaTypeEnum mediaType) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.mediaType = mediaType;
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
    
    
    
}
