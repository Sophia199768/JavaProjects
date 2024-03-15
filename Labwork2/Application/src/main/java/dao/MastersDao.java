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
        try {
            Session addNewMasterSession = getSessionFactory().openSession();
            Transaction transaction = addNewMasterSession.beginTransaction();
            addNewMasterSession.persist(newMaster);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Master> read() {
        return null;
    }

    @Override
    public void update(Master master) {
        Session updateMasterSession = null;
        try {
            updateMasterSession = getSessionFactory().openSession();
            Transaction transaction = updateMasterSession.beginTransaction();
            updateMasterSession.update(master);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Master findById(Integer id) {
        Master master = null;
        Session findMasterSession = null;
        try {
            findMasterSession = getSessionFactory().openSession();
            Transaction transaction = findMasterSession.beginTransaction();
            master = findMasterSession.get(Master.class, id);
            transaction.commit();
        } catch (Exception e) {
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
        try {
            deleteMasterSession = getSessionFactory().openSession();
            Transaction transaction = deleteMasterSession.beginTransaction();
            Master master = findById(id);
            deleteMasterSession.remove(master);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deleteMasterSession != null && deleteMasterSession.isOpen()) {
                deleteMasterSession.close();
            }
        }
    }
}
