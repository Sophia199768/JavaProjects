package com.example.application.kafka;

import com.example.linkagecatmaster.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, Integer> kafkaIntTemplate;
    private final KafkaTemplate<String, CreateMasterDto> kafkaCreateMasterTemplate;
    private final KafkaTemplate<String, CatDto> kafkaCatTemplate;
    private final KafkaTemplate<String, UpdateMasterDto> kafkaMasterTemplate;
    private final KafkaTemplate<String, MasterIdAndCatIdDto> kafkaMasterCatTemplate;
    private final KafkaTemplate<String, FriendsDto> kafkaFriendsTemplate;

    public void findMasterById(Integer id) {
        kafkaIntTemplate.send("findMasterById", id);
    }

    public void findCatById(Integer id) {
        kafkaIntTemplate.send("findCatById", id);
    }

    public void createMaster(CreateMasterDto master) {
        kafkaCreateMasterTemplate.send("createMaster", master);
    }

    public void createCat(CatDto cat) {
        kafkaCatTemplate.send("createMaster", cat);
    }

    public void updateMasterName(UpdateMasterDto master) {
        kafkaMasterTemplate.send("updateMasterName", master);
    }

    public void updateCatName(CatDto cat) { kafkaCatTemplate.send("updateName", cat); }

    public void deleteMaster(Integer id) {
        kafkaIntTemplate.send("deleteMaster", id);
    }

    public void deleteCat(Integer id) {
        kafkaIntTemplate.send("deleteCat", id);
    }

    public void addNewCat(MasterIdAndCatIdDto masterCat) { kafkaMasterCatTemplate.send("addNewCat", masterCat); }

    public void  setFriends(FriendsDto friends) {
        kafkaFriendsTemplate.send("makeFriends", friends);
    }

    public void findAllMasters() {
        kafkaIntTemplate.send("findAllMasters", 1);
    }

    public void findAllCats() { kafkaIntTemplate.send("findAllCats", 1); }

    public void findAllCatsFiltered(CatDto request) { kafkaCatTemplate.send("findAllCatsFiltered", request); }
}
