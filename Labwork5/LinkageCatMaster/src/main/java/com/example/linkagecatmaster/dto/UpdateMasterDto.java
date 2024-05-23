package com.example.linkagecatmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMasterDto {
    private Integer id;
    private String login;
    private Date birthday;
}
