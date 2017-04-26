package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.User;
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
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(User item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    public void delete(Integer id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        if (user != null)  {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    public User update(User item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public User get(Integer id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
