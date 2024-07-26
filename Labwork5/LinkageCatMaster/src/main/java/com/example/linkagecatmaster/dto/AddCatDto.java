package com.example.linkagecatmaster.dto;

import com.example.linkagecatmaster.models.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCatDto {
    private Integer masterId;
    private Cat cat;
}
