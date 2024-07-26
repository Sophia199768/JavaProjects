package com.example.application.response;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseGetMaster {
    private Integer id;
    private  String name;
    private Date birthday;
}
