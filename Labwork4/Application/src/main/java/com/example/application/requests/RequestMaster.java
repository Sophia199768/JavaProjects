package com.example.application.requests;

import com.example.core.model.Cat;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RequestMaster {
    private Integer id;
    private String login;
    private Date birthday;
}
