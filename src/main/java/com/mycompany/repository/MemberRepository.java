/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.entity.MemberEntity;
import java.sql.SQLException;
import java.util.List;

/**
 * this tells tells the implentation what we can do, its a inteface stepping stone
 *
 * @author m2505660
 */
public interface MemberRepository {

//this is the questiosn that we can ask about members, so far its just find everyone, later it will be delete, add or whatever.
    List<MemberEntity> finalAll() throws SQLException;

    List<MemberEntity> findMembers() throws SQLException;
}
