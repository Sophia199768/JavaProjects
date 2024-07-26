package com.example.application.requests;

import lombok.Data;

import java.util.Date;

@Data
public class RequestCat {
    private Integer id;
    private  String name;
    private Date birthday;
    private String breed;
    private String color;
}
