/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

/**
 * What defines a member
 *
 * @author m2505660
 */
public class MemberEntity {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String accessLevel;

    public MemberEntity(int id, String firstName, String lastName, String email, String accessLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

}
