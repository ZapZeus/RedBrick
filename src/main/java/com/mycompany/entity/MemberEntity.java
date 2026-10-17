/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

import com.mycompany.enums.AccessLevelEnum;

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
    private AccessLevelEnum accessLevel;

    public MemberEntity(int id, String firstName, String lastName, String email, AccessLevelEnum accessLevel) {
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

    public AccessLevelEnum getAccessLevel() {
        return accessLevel;
    }


}
