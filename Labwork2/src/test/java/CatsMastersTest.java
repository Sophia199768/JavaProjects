import dao.CatDao;
import dao.MastersDao;
import model.Cat;
import model.Master;
import service.CatsService;
import service.MasterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class CatsMastersTest {

    @Test
    public void catCreateTest() {
        CatsService catsService = new CatsService(new CatDao());
        List<Cat> cats = new ArrayList<>();
        catsService.createCat("Sima", new Date(2014, Calendar.MAY, 12), "britan", "grey-blue", cats);

        Cat myCat = catsService.findById(1);

        Assertions.assertNotNull(myCat);
    }

    @Test
    public void masterCreateTest() {
        MasterService mastersService = new MasterService(new MastersDao());
        mastersService.createMaster("Ann", new Date(2008, Calendar.JULY, 8), new ArrayList<>());

        Master master = mastersService.findById(1);

        Assertions.assertNotNull(master);
    }


    @Test
    public void madeFriendsCatTest() {
        CatsService catsService = new CatsService(new CatDao());
        List<Cat> cats = new ArrayList<>();
        catsService.createCat("Simka", new Date(2014, Calendar.MAY, 12), "britan", "grey-blue", cats);

        Cat firstCat = catsService.findById(1);
        Cat secondCat = catsService.findById(2);
        catsService.madeCatsFriends(firstCat, secondCat);

        Assertions.assertNotEquals(firstCat.getFriendsCats().size(), 0);
    }

    @Test
    public void addNewCatTest() {
        CatsService catsService = new CatsService(new CatDao());
        MasterService masterService = new MasterService(new MastersDao());

        Cat cat = catsService.findById(1);
        Master master = masterService.findById(1);
        masterService.addNewCat(master, cat);

        Assertions.assertNotEquals(master.getCats(), 0);
    }
}