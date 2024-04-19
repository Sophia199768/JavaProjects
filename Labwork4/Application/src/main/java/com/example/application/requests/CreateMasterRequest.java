package com.example.application.requests;

import com.example.core.model.Role;
import lombok.Data;

import java.util.Date;

@Data
public class CreateMasterRequest {
    private String login;
    private String password;
    private Date birthday;
    private Role role;
}
