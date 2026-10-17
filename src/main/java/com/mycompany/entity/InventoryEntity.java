/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

import com.mycompany.enums.InventoryEnum;

/**
 *
 * @author parks
 */
public class InventoryEntity {
    private int inventoryId;
    private String isbn;
    private InventoryEnum inventoryStatus;

    public InventoryEntity(int inventoryId, String isbn, InventoryEnum inventoryStatus) {
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.inventoryStatus = inventoryStatus;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public InventoryEnum getInventoryStatus() {
        return inventoryStatus;
    }
    
    
}
