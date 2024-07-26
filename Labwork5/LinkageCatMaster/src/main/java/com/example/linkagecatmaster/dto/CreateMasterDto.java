package com.example.linkagecatmaster.dto;

import com.example.linkagecatmaster.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMasterDto {
    private String login;
    private String password;
    private Date birthday;
    private Role role;
}
