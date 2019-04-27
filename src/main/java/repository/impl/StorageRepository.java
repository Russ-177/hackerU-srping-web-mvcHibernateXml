package repository.impl;

import entity.Storage;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import utils.HibernateUtil;


@Component
public class StorageRepository implements IRepository<Storage>{
    @Override
    public Storage get(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Storage storage = session.get(Storage.class, id);
        session.getTransaction().commit();
        return storage;
    }

    @Override
    public List<Storage> get() {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<Storage> list =  session.createQuery( "from Storage " ).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public boolean insert(Storage item) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            session.save(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Storage item) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            session.saveOrUpdate(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            Storage item = session.get(Storage.class, id);
            session.delete(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
