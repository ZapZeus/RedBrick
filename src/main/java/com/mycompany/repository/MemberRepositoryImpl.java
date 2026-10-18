
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.enums.AccessLevelEnum;
import com.mycompany.entity.MemberEntity;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This is where we will write the SQL queries
 *
 * @author parks
 */
public class MemberRepositoryImpl implements MemberRepository {

    private final DatabaseConnectionImpl database = new DatabaseConnectionImpl();

    // Retrieves all accounts, including admins.
    @Override
    public List<MemberEntity> finalAll() throws SQLException {

        List<MemberEntity> members = new ArrayList<>();

        String sql = "SELECT * FROM members";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {

                MemberEntity member = new MemberEntity(
                        results.getInt("member_id"),
                        results.getString("first_name"),
                        results.getString("last_name"),
                        results.getString("email"),
                        AccessLevelEnum.valueOf(results.getString("access_level"))); // changed the database to access level because it annoyed me.

                members.add(member);
            }
        }

        return members;
    }

    // Retrieves only accounts with MEMBER access.
    @Override
    public List<MemberEntity> findMembers() throws SQLException {

        List<MemberEntity> members = new ArrayList<>();

        String sql = "SELECT * FROM members WHERE access_level = 'MEMBER'";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {

                MemberEntity member = new MemberEntity(
                        results.getInt("member_id"),
                        results.getString("first_name"),
                        results.getString("last_name"),
                        results.getString("email"),
                        AccessLevelEnum.valueOf(results.getString("access_level")));

                members.add(member);
            }
        }

        return members;
    }
}
