package com.example.application.controller;

import com.example.application.kafka.KafkaConsumer;
import com.example.application.kafka.KafkaProducer;
import com.example.application.response.ResponseGetMaster;
import com.example.linkagecatmaster.dto.CreateMasterDto;
import com.example.linkagecatmaster.dto.MasterIdAndCatIdDto;
import com.example.linkagecatmaster.dto.UpdateMasterDto;
import com.example.linkagecatmaster.models.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/masters")
@RequiredArgsConstructor
public class MastersController {
    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @GetMapping("/{id}")
    public ResponseGetMaster getById(@PathVariable Integer id) {

        kafkaProducer.findMasterById(id);

        Master master;
        try {
          master = kafkaConsumer.waitForMasterResponse();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ResponseGetMaster getMaster = new ResponseGetMaster();
        getMaster.setId(master.getId());
        getMaster.setName(master.getLogin());
        getMaster.setBirthday(master.getBirthday());
        return getMaster;
    }

    @PostMapping("/newmaster")
    public void create(@RequestBody CreateMasterDto master) {
        kafkaProducer.createMaster(master);
    }

    @PutMapping("/name")
    public void updateName(@RequestBody UpdateMasterDto master) {
        kafkaProducer.updateMasterName(master);
    }

    @PutMapping("/owncat")
    public void addNewCat(@RequestBody MasterIdAndCatIdDto masterCat) {
        kafkaProducer.addNewCat(masterCat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
       kafkaProducer.deleteMaster(id);
    }

    @GetMapping("/all")
    public List<ResponseGetMaster> getAll() throws InterruptedException {
        kafkaProducer.findAllMasters();
        return kafkaConsumer.waitForAllMasterResponse().stream().map(master -> {ResponseGetMaster response = new ResponseGetMaster();
            response.setId(master.getId());
            response.setName(master.getLogin());
            response.setBirthday(master.getBirthday());
            return response;
        }).collect(Collectors.toList());
    }
}