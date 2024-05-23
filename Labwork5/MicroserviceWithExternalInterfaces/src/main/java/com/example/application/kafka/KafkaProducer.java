package com.example.application.kafka;

import com.example.linkagecatmaster.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaIntTemplate;

    public void findMasterById(Integer id) {
        kafkaIntTemplate.send("findMasterById", id);
    }

    public void findCatById(Integer id) {
        kafkaIntTemplate.send("findCatById", id);
    }

    public void createMaster(CreateMasterDto master) {
        kafkaIntTemplate.send("createMaster", master);
    }

    public void createCat(CatDto cat) {
        kafkaIntTemplate.send("createCat", cat);
    }

    public void updateMasterName(UpdateMasterDto master) { kafkaIntTemplate.send("updateMasterName", master);
    }

    public void updateCatName(CatDto cat) { kafkaIntTemplate.send("updateName", cat); }

    public void deleteMaster(Integer id) {
        kafkaIntTemplate.send("deleteMaster", id);
    }

    public void deleteCat(Integer id) {
        kafkaIntTemplate.send("deleteCat", id);
    }

    public void addNewCat(MasterIdAndCatIdDto masterCat) { kafkaIntTemplate.send("addNewCat", masterCat); }

    public void  setFriends(FriendsDto friends) {
        kafkaIntTemplate.send("makeFriends", friends);
    }

    public void findAllMasters() {
        kafkaIntTemplate.send("findAllMasters", 1);
    }

    public void findAllCats() { kafkaIntTemplate.send("findAllCats", 1); }

    public void findAllCatsFiltered(CatDto request) { kafkaIntTemplate.send("findAllCatsFiltered", request); }
}
