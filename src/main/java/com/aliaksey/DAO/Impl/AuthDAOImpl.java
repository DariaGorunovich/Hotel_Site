package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.AuthDAO;
import com.aliaksey.entity.Auth;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
@Repository
@Transactional
public class AuthDAOImpl implements AuthDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Auth item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<Auth> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Auth> authList = session.createQuery("from Auth").list();
        return authList;
    }

    public void delete(Integer id) {
        Auth auth = sessionFactory.getCurrentSession().get(Auth.class, id);
        if (auth != null)  {
            this.sessionFactory.getCurrentSession().delete(auth);
        }
    }

    public Auth update(Auth item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public Auth get(Integer id) {
        return sessionFactory.getCurrentSession().get(Auth.class, id);
    }
}
