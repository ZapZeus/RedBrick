/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.dto.MemberDto;
import com.mycompany.model.entity.MemberEntity;
import com.mycompany.model.entity.repository.MemberRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *Handles logic for library members, retrieves information from the repo converts it into MemberEntity then Data transfer object. for the api.
 *
 * @author m2505660
 *
 */
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<MemberEntity> getAllMembers() throws SQLException {
        return repository.finalAll();
    }

    public List<MemberDto> getMemberDtos() throws SQLException {

        List<MemberEntity> members = repository.finalAll();
        List<MemberDto> memberDtos = new ArrayList<>();

        for (MemberEntity member : members) {

            MemberDto dto = new MemberDto(
                    member.getId(),
                    member.getFirstName(),
                    member.getLastName()
            );

            memberDtos.add(dto);
        }

        return memberDtos;
    }

}
