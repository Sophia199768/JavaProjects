package com.example.application.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseGetCat {
    private Integer id;
    private  String name;
    private Date birthday;
    private String breed;
    private String color;
}
