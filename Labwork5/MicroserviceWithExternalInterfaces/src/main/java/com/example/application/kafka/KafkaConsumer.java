package com.example.application.kafka;

import com.example.linkagecatmaster.models.Cat;
import com.example.linkagecatmaster.models.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final BlockingQueue<Master> responseMasterQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<List<Master>> responseAllMasterQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<Cat> responseCatQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<List<Cat>> responseAllCatsQueue = new LinkedBlockingQueue<>();

    public Master waitForMasterResponse() throws InterruptedException {
        return responseMasterQueue.poll(5, TimeUnit.SECONDS);
    }

    public Cat waitForCatResponse() throws InterruptedException {
        return responseCatQueue.poll(5, TimeUnit.SECONDS);
    }

    public List<Cat> waitForAllCatsResponse() throws InterruptedException {
        return responseAllCatsQueue.poll(5, TimeUnit.SECONDS);
    }

    public List<Master> waitForAllMasterResponse() throws InterruptedException {
        return responseAllMasterQueue.poll(5, TimeUnit.SECONDS);
    }

    @KafkaListener(topics = "findMasterById", groupId = "consumer")
    public void listenerMaster(Master master) {
        responseMasterQueue.offer(master);
    }


    @KafkaListener(topics = "findCatById", groupId = "consumer")
    public void listenerCat(Cat cat) {
        responseCatQueue.offer(cat);
    }

    @KafkaListener(topics = "allMasters", groupId = "consumer")
    public void listenerAllMasters(List<Master> masters) {
        responseAllMasterQueue.offer(masters);
    }

    @KafkaListener(topics = "allCats", groupId = "consumer")
    public void listenerAllCats(List<Cat> cats) {
        responseAllCatsQueue.offer(cats);
    }

}
