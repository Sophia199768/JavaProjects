package com.example.microserviceforaccessingcats.kafka;

import com.example.linkagecatmaster.dto.AddCatDto;
import com.example.linkagecatmaster.dto.CatDto;
import com.example.linkagecatmaster.models.Cat;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void addNewCat(AddCatDto catDto) {
        kafkaTemplate.send("addNewCat", catDto);
    }

    public void findCat(Cat cat) {
        CatDto catDto = new CatDto(cat.getId(), cat.getName(), cat.getBirthday(), cat.getBreed(), cat.getColor());
        kafkaTemplate.send("findCat", catDto);
    }

    public void findAllCats(List<Cat> cats) {
        List<CatDto> catsDto = cats.stream().map(cat -> {
            CatDto response = new CatDto();
            response.setId(cat.getId());
            response.setName(cat.getName());
            response.setBirthday(cat.getBirthday());
            response.setBreed(cat.getBreed());
            response.setColor(cat.getColor());
            return response;
        }).collect(Collectors.toList());
        kafkaTemplate.send("allCats", catsDto);
    }
}
