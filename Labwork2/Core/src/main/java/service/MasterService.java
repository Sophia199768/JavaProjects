package service;

import model.Cat;
import model.Master;
import ports.MastersDaoInterface;
import ports.MastersServiceInterface;

import java.util.Date;
import java.util.List;

public class MasterService implements MastersServiceInterface {
    public MastersDaoInterface mastersDao;

    public MasterService(MastersDaoInterface mastersDao) {
        this.mastersDao = mastersDao;
    }

    @Override
    public void createMaster(String name, Date birthday, List<Cat> listOfCats) {
        mastersDao.createMaster(name, birthday, listOfCats);
    }

    @Override
    public void addNewCat(Master master, Cat cat) {
        master.getCats().add(cat);
        mastersDao.update(master);
    }

    @Override
    public List<Master> read() {
        mastersDao.read();
        return null;
    }

    @Override
    public void update(Master master) {
        mastersDao.update(master);
    }

    @Override
    public void delete(Integer id) {
        mastersDao.delete(id);
    }

    @Override
    public Master findById(Integer id) {
        return mastersDao.findById(id);
    }
}
