package com.example.application;

import com.example.core.model.Cat;
import com.example.core.model.Master;
import com.example.core.service.CatsService;
import com.example.core.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
@RequiredArgsConstructor
class ApplicationTests {

    private final CatsService catsService;
    private final MasterService masterService;

    @Test
    public void catCreateTest() {
        catsService.createCat("Sima", new Date(2014, Calendar.MAY, 12), "britan", "grey-blue");

        Cat myCat = catsService.findById(1);

        Assertions.assertNotNull(myCat);
    }

    @Test
    public void masterCreateTest() {
        masterService.createMaster("Ann", new Date(2008, Calendar.JULY, 8));

        Master master = masterService.findById(1);

        Assertions.assertNotNull(master);
    }


    @Test
    public void madeFriendsCatTest() {
        catsService.createCat("Simka", new Date(2014, Calendar.MAY, 12), "britan", "grey-blue");
        catsService.madeCatsFriends(1, 2);
        Cat firstCat = catsService.findById(1);
        Assertions.assertNotEquals(firstCat.getFriendsCats().size(), 0);
    }

    @Test
    public void addNewCatTest() {
        masterService.addNewCat(1, 1);
        Master master = masterService.findById(1);
        Assertions.assertNotEquals(master.getCats(), 0);
    }
}
