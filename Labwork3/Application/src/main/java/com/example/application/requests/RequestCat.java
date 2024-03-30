package com.example.application.requests;


import com.example.core.model.Cat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RequestCat {
    private Integer id;
    private  String name;
    private Date birthday;
    private String breed;
    private String color;
}
