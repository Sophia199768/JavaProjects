package dao;

import model.Cat;
import model.Master;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ports.MastersDaoInterface;

import java.util.Date;
import java.util.List;

import static hibernateUtil.HibernateUtil.getSessionFactory;

public class MastersDao implements MastersDaoInterface {
    @Override
    public void createMaster(String name, Date birthday, List<Cat> listOfCat) {
        Master newMaster = new Master(name, birthday, listOfCat);
        Session addNewMasterSession = null;
        Transaction transaction = null;
        try {
            addNewMasterSession = getSessionFactory().openSession();
            transaction = addNewMasterSession.beginTransaction();
            addNewMasterSession.persist(newMaster);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (addNewMasterSession != null && addNewMasterSession.isOpen()) {
                addNewMasterSession.close();
            }
        }
    }

    @Override
    public List<Master> read() {
        return null;
    }

    @Override
    public void update(Master master) {
        Session updateMasterSession = null;
        Transaction transaction = null;
        try {
            updateMasterSession = getSessionFactory().openSession();
            transaction = updateMasterSession.beginTransaction();
            updateMasterSession.update(master);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (updateMasterSession != null && updateMasterSession.isOpen()) {
                updateMasterSession.close();
            }
        }
    }

    @Override
    public Master findById(Integer id) {
        Master master = null;
        Session findMasterSession = null;
        Transaction transaction = null;
        try {
            findMasterSession = getSessionFactory().openSession();
            transaction = findMasterSession.beginTransaction();
            master = findMasterSession.get(Master.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (findMasterSession != null && findMasterSession.isOpen()) {
                findMasterSession.close();
            }
        }

        return master;
    }

    @Override
    public void delete(Integer id) {
        Session deleteMasterSession = null;
        Transaction transaction = null;
        try {
            deleteMasterSession = getSessionFactory().openSession();
            transaction = deleteMasterSession.beginTransaction();
            Master master = findById(id);
            deleteMasterSession.remove(master);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (deleteMasterSession != null && deleteMasterSession.isOpen()) {
                deleteMasterSession.close();
            }
        }
    }
}
