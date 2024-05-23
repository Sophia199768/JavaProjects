package com.example.application.kafka;

import com.example.linkagecatmaster.dto.CatDto;
import com.example.linkagecatmaster.dto.MasterDto;
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
    private final BlockingQueue<MasterDto> responseMasterQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<List<MasterDto>> responseAllMasterQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<CatDto> responseCatQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<List<CatDto>> responseAllCatsQueue = new LinkedBlockingQueue<>();

    public MasterDto waitForMasterResponse() throws InterruptedException {
        return responseMasterQueue.poll(20, TimeUnit.SECONDS);
    }

    public CatDto waitForCatResponse() throws InterruptedException {
        return responseCatQueue.poll(20, TimeUnit.SECONDS);
    }

    public List<CatDto> waitForAllCatsResponse() throws InterruptedException {
        return responseAllCatsQueue.poll(20, TimeUnit.SECONDS);
    }

    public List<MasterDto> waitForAllMasterResponse() throws InterruptedException {
        return responseAllMasterQueue.poll(20, TimeUnit.SECONDS);
    }

    @KafkaListener(topics = "findMaster", groupId = "consumer")
    public void listenerMaster(MasterDto master) {
        responseMasterQueue.offer(master);
    }


    @KafkaListener(topics = "findCat", groupId = "consumer")
    public void listenerCat(CatDto cat) {
        responseCatQueue.offer(cat);
    }

    @KafkaListener(topics = "allMasters", groupId = "consumer")
    public void listenerAllMasters(List<MasterDto> masters) {
        responseAllMasterQueue.offer(masters);
    }

    @KafkaListener(topics = "allCats", groupId = "consumer")
    public void listenerAllCats(List<CatDto> cats) {
        responseAllCatsQueue.offer(cats);
    }

}
