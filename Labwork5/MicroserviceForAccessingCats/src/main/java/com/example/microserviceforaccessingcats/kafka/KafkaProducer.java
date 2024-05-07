package com.example.microserviceforaccessingcats.kafka;

import com.example.linkagecatmaster.dto.AddCatDto;
import com.example.linkagecatmaster.models.Cat;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, AddCatDto> kafkaTemplate;
    private final KafkaTemplate<String, Cat> kafkaCatTemplate;
    private final KafkaTemplate<String, List<Cat>> kafkaAllCatsTemplate;

    public void addNewCat(AddCatDto catDto) {
        kafkaTemplate.send("addNewCat", catDto);
    }

    public void findCat(Cat cat) {
        kafkaCatTemplate.send("findCat", cat);
    }

    public void findAllCats(List<Cat> cats) {
        kafkaAllCatsTemplate.send("allCats", cats);
    }
}
