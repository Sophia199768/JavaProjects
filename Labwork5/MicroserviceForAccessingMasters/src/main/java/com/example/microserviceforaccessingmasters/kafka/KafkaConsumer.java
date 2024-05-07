package com.example.microserviceforaccessingmasters.kafka;

import com.example.linkagecatmaster.dto.AddCatDto;
import com.example.linkagecatmaster.models.Master;
import com.example.microserviceforaccessingmasters.ports.MasterRepositoryInterface;
import com.example.linkagecatmaster.dto.CreateMasterDto;
import com.example.linkagecatmaster.dto.UpdateMasterDto;
import com.example.microserviceforaccessingmasters.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final MasterService masterService;
    private final MasterRepositoryInterface masterRepositoryInterface;
    private final KafkaProducer kafkaProducer;

    @KafkaListener(topics = "addNewModelCat", groupId = "consumer")
    public void listenerForAddNewCat(AddCatDto catDto) {
        masterService.addNewCatKafka(catDto.getMasterId(), catDto.getCat());
    }

    @KafkaListener(topics = "masterUserNameKafka", groupId = "consumer")
    public void listenerForFindMasterByLogin(String username) {
        masterRepositoryInterface.findMasterByLogin(username);
    }

    @KafkaListener(topics = "findMasterById", groupId = "consumer")
    public void listenerForFindMasterById(Integer id) {
        masterRepositoryInterface.findMasterById(id);
    }

    @KafkaListener(topics = "createMaster", groupId = "consumer")
    public void listenerForCreate(CreateMasterDto master) {
        masterService.createMaster(master.getLogin(), master.getPassword(), master.getBirthday(), master.getRole());
    }

    @KafkaListener(topics = "updateMasterName", groupId = "consumer")
    public void listenerForUpdate(UpdateMasterDto master) {
        masterService.updateName(master.getId(), master.getLogin());
    }

    @KafkaListener(topics = "deleteMaster", groupId = "consumer")
    public void listenerForDelete(Integer id) {
        masterService.delete(id);
    }

    @KafkaListener(topics = "findAllMasters", groupId = "consumer")
    public void listenerForFindAll(Integer id) {
        List<Master> masters = masterService.findAll();
        kafkaProducer.findAllMasters(masters);
    }
}

