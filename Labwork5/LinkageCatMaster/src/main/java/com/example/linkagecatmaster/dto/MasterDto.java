package com.example.linkagecatmaster.dto;

import com.example.linkagecatmaster.models.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class MasterDto {
    private final Integer id;
    private final String login;
    private final Date birthday;
    private final Role role;
    private final String password;
}
