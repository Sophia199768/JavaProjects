package com.example.linkagecatmaster.dto;

import com.example.linkagecatmaster.models.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCatDto {
    private Integer masterId;
    private Cat cat;
}
