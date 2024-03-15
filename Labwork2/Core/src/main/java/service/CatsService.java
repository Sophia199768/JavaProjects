package service;

import ports.CatDaoInterface;
import model.Cat;
import ports.CatServiceInterface;

import java.util.Date;
import java.util.List;

public class CatsService implements CatServiceInterface {
    private CatDaoInterface catsDao;

    public CatsService(CatDaoInterface dao) {
        catsDao = dao;
    }

    @Override
    public void createCat(String name, Date birthday, String breed, String color, List<Cat> cats) {
        catsDao.createCat(name, birthday, breed, color, cats);
    }

    @Override
    public void madeCatsFriends(Cat catFriendOne, Cat catFriendTwo) {
        catFriendOne.getFriendsCats().add(catFriendTwo);
        catFriendTwo.getFriendsCats().add(catFriendOne);
        catsDao.update(catFriendOne);
        catsDao.update(catFriendTwo);
    }

    @Override
    public Cat findById(Integer id) {
        return catsDao.findById(id);
    }

    @Override
    public List<Cat> read(Cat cat) {
        return catsDao.read(cat);
    }

    @Override
    public void update(Cat cat) {
        catsDao.update(cat);
    }

    @Override
    public void delete(Integer id) {
        catsDao.delete(id);
    }
}
