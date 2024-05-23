package com.example.microserviceforaccessingmasters.kafka;

import com.example.linkagecatmaster.dto.CatDto;
import com.example.linkagecatmaster.dto.MasterDto;
import com.example.linkagecatmaster.dto.MasterIdAndCatIdDto;
import com.example.linkagecatmaster.models.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Integer masterId, Integer catId) {
        MasterIdAndCatIdDto ids = new MasterIdAndCatIdDto(masterId, catId);
        kafkaTemplate.send("sendKafka", ids);
    }

    public void findAllMasters(List<Master> masters) {
        List<MasterDto> mastersDto = masters.stream().map(master -> {
            MasterDto response = new MasterDto(master.getId(), master.getLogin(), master.getBirthday(), master.getRole(), master.getPassword());
            return response;
        }).collect(Collectors.toList());
        kafkaTemplate.send("allMasters", mastersDto);
    }


    public void findMasterId(Master master) {
        MasterDto masterDto = new MasterDto(master.getId(), master.getLogin(), master.getBirthday(), master.getRole(), master.getPassword());
        kafkaTemplate.send("findMaster", masterDto);
    }
}
