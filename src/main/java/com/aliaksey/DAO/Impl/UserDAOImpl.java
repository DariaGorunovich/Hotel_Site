package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.UserDAO;
import com.aliaksey.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(User item) {
        sessionFactory.getCurrentSession().persist(item);
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
        return null;
    }

    public User get(Integer id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
