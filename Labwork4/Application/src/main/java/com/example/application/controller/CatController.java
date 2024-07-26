package com.example.application.controller;
import com.example.application.requests.RequestCat;
import com.example.application.requests.RequestFriends;
import com.example.application.response.ResponseGetCat;
import com.example.core.model.Cat;

import com.example.core.service.CatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatsService catsService;

    @GetMapping("/{id}")
    public ResponseGetCat getById(@PathVariable Integer id) {
        Cat cat = catsService.findById(id);
        ResponseGetCat getCat = new ResponseGetCat();
        getCat.setId(cat.getId());
        getCat.setName(cat.getName());
        getCat.setColor(cat.getColor());
        getCat.setBreed(cat.getBreed());
        getCat.setBirthday(cat.getBirthday());
        return getCat;
    }

    @PostMapping("/newcat")
    public void create(@RequestBody RequestCat cat) {
        catsService.createCat(cat.getName(), cat.getBirthday(), cat.getBreed(), cat.getColor());
    }

    @PutMapping("/updatecat")
    public void updateName(@RequestBody RequestCat requestCat) {
        catsService.updateName(requestCat.getId(), requestCat.getName());
    }

    @PostMapping("/setfriends")
    public void setFriends(@RequestBody RequestFriends friends) {
        catsService.madeCatsFriends(friends.getFirstFriend(), friends.getSecondFriend());
    }

    @GetMapping("/filter")
    public List<ResponseGetCat> getFilterCats(@RequestBody RequestCat request) {
        return catsService.filter(request.getName(), request.getBreed(), request.getColor(), request.getBirthday()).stream().map(cat -> {
            ResponseGetCat response = new ResponseGetCat();
            response.setId(cat.getId());
            response.setName(cat.getName());
            response.setBirthday(cat.getBirthday());
            response.setBreed(cat.getBreed());
            response.setColor(cat.getColor());
            return response;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        catsService.delete(id);
    }

    @GetMapping("/all")
    public List<ResponseGetCat> getAll() {
        return catsService.findAll().stream().map(cat -> {
            ResponseGetCat response = new ResponseGetCat();
            response.setId(cat.getId());
            response.setName(cat.getName());
            response.setBirthday(cat.getBirthday());
            response.setBreed(cat.getBreed());
            response.setColor(cat.getColor());
            return response;
        }).collect(Collectors.toList());
    }
}