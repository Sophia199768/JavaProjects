package dao;

import model.Cat;
import org.hibernate.Session;

import org.hibernate.Transaction;
import ports.CatDaoInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static hibernateUtil.HibernateUtil.getSessionFactory;

public class CatDao implements CatDaoInterface {

    @Override
    public void createCat(String name, Date birthday, String breed, String color, List<Cat> cats) {
        Cat newCat = new Cat(name, birthday, breed, color, cats);
        try {
            Session addNewCatSession = getSessionFactory().openSession();
            Transaction transaction = addNewCatSession.beginTransaction();
            addNewCatSession.persist(newCat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cat> read(Cat cat) {
        return new ArrayList<>();
    }

    @Override
    public void update(Cat cat) {
        Session updateCatSession = null;
        try {
            updateCatSession = getSessionFactory().openSession();
            Transaction transaction = updateCatSession.beginTransaction();
            updateCatSession.update(cat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cat findById(Integer id) {
        Cat cat = null;
        Session findCatSession = null;
        try {
            findCatSession = getSessionFactory().openSession();
            Transaction transaction = findCatSession.beginTransaction();
            cat = findCatSession.get(Cat.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (findCatSession != null && findCatSession.isOpen()) {
               findCatSession.close();
            }
        }

        return cat;
    }

    @Override
    public void delete(Integer id) {
        Session deleteCatSession = null;
        try {
            deleteCatSession = getSessionFactory().openSession();
            Transaction transaction = deleteCatSession.beginTransaction();
            Cat catForDelete = findById(id);
            deleteCatSession.remove(catForDelete);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deleteCatSession != null && deleteCatSession.isOpen()) {
                deleteCatSession.close();
            }
        }
    }
}
