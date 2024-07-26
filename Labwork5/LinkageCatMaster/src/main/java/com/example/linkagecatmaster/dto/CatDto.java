package com.example.linkagecatmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatDto {
    private Integer id;
    private  String name;
    private Date birthday;
    private String breed;
    private String color;
}
