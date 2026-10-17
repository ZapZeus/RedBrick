/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto;

import com.mycompany.enums.InventoryEnum;

/**
 *
 * @author parks
 */
public class InventoryDto {
    private int inventoryId;
    private String isbn;
    private InventoryEnum status;

    public InventoryDto(int inventoryId, String isbn, InventoryEnum status) {
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.status = status;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public InventoryEnum getStatus() {
        return status;
    }
    
    
}
