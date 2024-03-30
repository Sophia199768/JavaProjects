package com.example.core.ports;

import com.example.core.model.Cat;
import com.example.core.model.Master;

import java.util.Date;
import java.util.List;

public interface MastersServiceInterface {
    void createMaster(String name, Date birthday);
    void addNewCat(Integer masterId, Integer catId);
    void updateName(Integer id, String newName);
    void delete(Integer id);
    Master findById(Integer id);
    List<Master> findAll();
}
