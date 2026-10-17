/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto;

import com.mycompany.enums.ReservationStatusEnum;
import java.time.LocalDate;

/**
 *
 * @author parks
 */
public class ReservationDto {
    private int reservationId;
    private String isbn;
    private int memberId;
    private LocalDate reservationDate;
    private ReservationStatusEnum reservationStatus;
    private int inventoryId;

    public ReservationDto(int reservationId, String isbn, int memberId, LocalDate reservationDate, ReservationStatusEnum reservationStatus, int inventoryId) {
        this.reservationId = reservationId;
        this.isbn = isbn;
        this.memberId = memberId;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
        this.inventoryId = inventoryId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public ReservationStatusEnum getReservationStatus() {
        return reservationStatus;
    }

    public int getInventoryId() {
        return inventoryId;
    }
    
    
}
