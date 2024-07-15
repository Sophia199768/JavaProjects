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
        Session addNewCatSession = null;
        Transaction transaction = null;
        try {
            addNewCatSession = getSessionFactory().openSession();
            transaction = addNewCatSession.beginTransaction();
            addNewCatSession.persist(newCat);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (addNewCatSession != null && addNewCatSession.isOpen()) {
                addNewCatSession.close();
            }
        }
    }

    @Override
    public List<Cat> read(Cat cat) {
        return new ArrayList<>();
    }

    @Override
    public void update(Cat cat) {
        Session updateCatSession = null;
        Transaction transaction = null;
        try {
            updateCatSession = getSessionFactory().openSession();
            transaction = updateCatSession.beginTransaction();
            updateCatSession.update(cat);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (updateCatSession != null && updateCatSession.isOpen()) {
                updateCatSession.close();
            }
        }
    }

    @Override
    public Cat findById(Integer id) {
        Cat cat = null;
        Session findCatSession = null;
        Transaction transaction = null;
        try {
            findCatSession = getSessionFactory().openSession();
            transaction = findCatSession.beginTransaction();
            cat = findCatSession.get(Cat.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
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
        Transaction transaction = null;
        try {
            deleteCatSession = getSessionFactory().openSession();
            transaction = deleteCatSession.beginTransaction();
            Cat catForDelete = findById(id);
            deleteCatSession.remove(catForDelete);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (deleteCatSession != null && deleteCatSession.isOpen()) {
                deleteCatSession.close();
            }
        }
    }
}
