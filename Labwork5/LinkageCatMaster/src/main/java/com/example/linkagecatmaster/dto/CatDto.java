package com.example.linkagecatmaster.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CatDto {
    private Integer id;
    private  String name;
    private Date birthday;
    private String breed;
    private String color;
}
