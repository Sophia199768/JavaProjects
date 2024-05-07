package com.example.linkagecatmaster.dto;

import com.example.linkagecatmaster.models.Role;
import lombok.Data;

import java.util.Date;
@Data
public class CreateMasterDto {
    private String login;
    private String password;
    private Date birthday;
    private Role role;
}
