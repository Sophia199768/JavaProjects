package com.example.application.controller;

import com.example.application.kafka.KafkaConsumer;
import com.example.application.kafka.KafkaProducer;
import com.example.linkagecatmaster.dto.FriendsDto;
import com.example.application.response.ResponseGetCat;
import com.example.linkagecatmaster.dto.CatDto;
import com.example.linkagecatmaster.models.Cat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {
    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @GetMapping("/{id}")
    public ResponseGetCat getById(@PathVariable Integer id) {

        kafkaProducer.findCatById(id);

       Cat cat;
        try {
            cat = kafkaConsumer.waitForCatResponse();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ResponseGetCat getCat = new ResponseGetCat();
        getCat.setId(cat.getId());
        getCat.setName(cat.getName());
        getCat.setColor(cat.getColor());
        getCat.setBreed(cat.getBreed());
        getCat.setBirthday(cat.getBirthday());
        return getCat;
    }

    @PostMapping("/newcat")
    public void create(@RequestBody CatDto cat) {
        kafkaProducer.createCat(cat);
    }

    @PutMapping("/updatecat")
    public void updateName(@RequestBody CatDto cat) {
        kafkaProducer.updateCatName(cat);
    }

    @PostMapping("/setfriends")
    public void setFriends(@RequestBody FriendsDto friends) {
        kafkaProducer.setFriends(friends);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        kafkaProducer.deleteCat(id);
    }

    @GetMapping("/filter")
    public List<ResponseGetCat> getFilterCats(@RequestBody CatDto request) throws InterruptedException {
        kafkaProducer.findAllCatsFiltered(request);
        return kafkaConsumer.waitForAllCatsResponse().stream().map(cat -> {
            ResponseGetCat response = new ResponseGetCat();
            response.setId(cat.getId());
            response.setName(cat.getName());
            response.setBirthday(cat.getBirthday());
            response.setBreed(cat.getBreed());
            response.setColor(cat.getColor());
            return response;
        }).collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<ResponseGetCat> getAll() throws InterruptedException {
        kafkaProducer.findAllCats();
        return kafkaConsumer.waitForAllCatsResponse().stream().map(cat -> {
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