package com.example.microserviceforaccessingcats.kafka;

import com.example.linkagecatmaster.dto.AddCatDto;
import com.example.linkagecatmaster.dto.CatDto;
import com.example.linkagecatmaster.dto.FriendsDto;
import com.example.linkagecatmaster.dto.MasterIdAndCatIdDto;
import com.example.linkagecatmaster.models.Cat;
import com.example.microserviceforaccessingcats.service.CatsService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final CatsService catsService;
    private final KafkaProducer kafkaProducer;

    @KafkaListener(topics = "addNewCat", groupId = "consumer")
    public void addNewCatListener(MasterIdAndCatIdDto ids) {
        Cat newCat = catsService.findById(ids.getCatId());
        AddCatDto dto = new AddCatDto(ids.getMasterId(), newCat);
        kafkaProducer.addNewCat(dto);
    }

    @KafkaListener(topics = "createCat", groupId = "consumer")
    public void createListener(CatDto cat) {
        catsService.createCat(cat.getName(), cat.getBirthday(), cat.getBreed(), cat.getColor());
    }

    @KafkaListener(topics = "findCatById", groupId = "consumer")
    public void findByIdListener(Integer id) {
        Cat cat = catsService.findById(id);
        kafkaProducer.findCat(cat);
    }

    @KafkaListener(topics = "updateCatName", groupId = "consumer")
    public void updateCatNameListener(CatDto cat) {
        catsService.updateName(cat.getId(), cat.getName());
    }

    @KafkaListener(topics = "deleteCat", groupId = "consumer")
    public void deleteCatListener(Integer id) {
        catsService.delete(id);
    }

    @KafkaListener(topics = "makeFriends", groupId = "consumer")
    public void makeFriendsListener(FriendsDto friendsDto) {
         catsService.madeCatsFriends(friendsDto.getFirstFriend(), friendsDto.getSecondFriend());
    }

    @KafkaListener(topics = "findAllCats", groupId = "consumer")
    public void findAllCats(Integer id) {
        List<Cat> cats = catsService.findAll();
        kafkaProducer.findAllCats(cats);
    }

    @KafkaListener(topics = "findAllCatsFiltered", groupId = "consumer")
    public void findAllCatsFiltered(CatDto cat) {
        List<Cat> cats = catsService.filter(cat.getName(), cat.getBreed(), cat.getColor(), cat.getBirthday());
        kafkaProducer.findAllCats(cats);
    }

}
