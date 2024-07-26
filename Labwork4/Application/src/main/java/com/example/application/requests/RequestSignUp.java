package com.example.application.requests;

import lombok.Data;

import java.util.Date;

@Data
public class RequestSignUp {
    private String name;
    private String password;
    private Date birthday;
}
