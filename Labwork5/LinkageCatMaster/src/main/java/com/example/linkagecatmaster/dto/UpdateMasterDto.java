package com.example.linkagecatmaster.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateMasterDto {
    private Integer id;
    private String login;
    private Date birthday;
}
