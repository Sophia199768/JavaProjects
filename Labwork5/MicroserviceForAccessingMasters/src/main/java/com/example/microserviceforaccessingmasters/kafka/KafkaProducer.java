package com.example.microserviceforaccessingmasters.kafka;

import com.example.linkagecatmaster.dto.MasterIdAndCatIdDto;
import com.example.linkagecatmaster.models.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, MasterIdAndCatIdDto> kafkaTemplate;
    private final KafkaTemplate<String, List<Master>> kafkaFindAllMastersTemplate;

    public void sendMessage(Integer masterId, Integer catId) {
        MasterIdAndCatIdDto ids = new MasterIdAndCatIdDto(masterId, catId);
        kafkaTemplate.send("sendKafka", ids);
    }

    public void findAllMasters(List<Master> masters) {
        kafkaFindAllMastersTemplate.send("allMasters", masters);
    }
}
