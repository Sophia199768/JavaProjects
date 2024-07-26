package com.example.microserviceforaccessingcats.service;

import com.example.linkagecatmaster.models.Cat;
import com.example.microserviceforaccessingcats.ports.CatRepositoryInterface;
import com.example.microserviceforaccessingcats.ports.CatServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatsService implements CatServiceInterface {
    private final CatRepositoryInterface catRepository;


    @Override
    public void createCat(String name, Date birthday, String breed, String color) {
        Cat newCat = new Cat(name, birthday, breed, color);
        catRepository.save(newCat);
    }

    @Override
    public void madeCatsFriends(Integer catFriendOne, Integer catFriendTwo) {
        Cat firstCat = catRepository.findCatById(catFriendOne);
        Cat secondCat = catRepository.findCatById(catFriendTwo);
        firstCat.getFriendsCats().add(secondCat);
        secondCat.getFriendsCats().add(firstCat);
        catRepository.save(firstCat);
        catRepository.save(secondCat);
    }

    @Override
    public Cat findById(Integer id) {
        return catRepository.findCatById(id);
    }

    @Override
    public void updateName(Integer id, String newName) {
        Cat cat = catRepository.findCatById(id);
        cat.setName(newName);
        catRepository.save(cat);
    }

    @Override
    public void delete(Integer id) {
        catRepository.deleteCatById(id);
    }

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public List<Cat> filter(String name, String breed, String color, Date birthday) {

       List<Cat> answer = findAll();

       if (name != null) {
           answer = answer.stream().filter(cat -> cat.getName().equals(name)).toList();
       }

       if (breed != null) {
           answer = answer.stream().filter(cat -> cat.getBreed().equals(breed)).toList();
       }

       if (color != null) {
           answer = answer.stream().filter(cat -> cat.getBirthday().equals(birthday)).toList();
       }

       if (birthday != null) {
          answer = answer.stream().filter(cat -> cat.getColor().equals(color)).toList();
       }

       return answer;
    }
}
