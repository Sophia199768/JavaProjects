package com.example.microserviceforaccessingmasters.ports;

import com.example.linkagecatmaster.models.Master;
import com.example.linkagecatmaster.models.Role;

import java.util.Date;
import java.util.List;

public interface MastersServiceInterface {
    void createMaster(String name, String password, Date birthday, Role role);
    void addNewCat(Integer masterId, Integer catId);
    void updateName(Integer id, String newName);
    void delete(Integer id);
    Master findById(Integer id);
    List<Master> findAll();
}
