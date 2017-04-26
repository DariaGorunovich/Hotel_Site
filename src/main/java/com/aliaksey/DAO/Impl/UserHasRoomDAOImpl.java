package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.UserDAO;
import com.aliaksey.DAO.UserHasRoomDAO;
import com.aliaksey.entity.User;
import com.aliaksey.entity.UserHasRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kirik on 26.04.2017.
 */

@Repository
@Transactional
public class UserHasRoomDAOImpl implements UserHasRoomDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(UserHasRoom item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<UserHasRoom> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<UserHasRoom> usersHasRoom = session.createQuery("from UserHasRoom").list();
        return usersHasRoom;
    }

    public void delete(Integer id) {
        UserHasRoom userHasRoom = sessionFactory.getCurrentSession().get(UserHasRoom.class, id);
        if (userHasRoom != null)  {
            this.sessionFactory.getCurrentSession().delete(userHasRoom);
        }
    }

    public UserHasRoom update(UserHasRoom item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public UserHasRoom get(Integer id) {
        return sessionFactory.getCurrentSession().get(UserHasRoom.class, id);
    }
}
