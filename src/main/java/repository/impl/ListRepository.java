package repository.impl;

import entity.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import utils.HibernateUtil;


@Component
public class ListRepository implements IRepository<List>{
        @Override
    public List get(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List list = session.get(List.class, id);
        session.getTransaction().commit();
        return list;
    }

    @Override
    public java.util.List get() {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        java.util.List list =  session.createQuery( "from List " ).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public boolean insert(List item) {
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
    public boolean update(List item) {
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
            List item = session.get(List.class, id);
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
