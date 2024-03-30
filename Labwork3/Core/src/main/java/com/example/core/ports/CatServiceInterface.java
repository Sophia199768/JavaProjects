package com.example.core.ports;

import com.example.core.model.Cat;

import java.util.Date;
import java.util.List;

public interface CatServiceInterface {
    void createCat(String name, Date birthday, String breed, String color);
    void madeCatsFriends(Integer catFriendOne, Integer catFriendTwo);
    Cat findById(Integer id);
    void updateName(Integer id, String newName);
    void delete(Integer id);
    List<Cat> findAll();
}