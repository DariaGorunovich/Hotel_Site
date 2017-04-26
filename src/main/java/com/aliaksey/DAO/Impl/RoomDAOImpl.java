package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.RoomDAO;
import com.aliaksey.entity.Room;
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
public class RoomDAOImpl implements RoomDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Room item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<Room> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Room> rooms = session.createQuery("from Room").list();
        return rooms;
    }

    public void delete(Integer id) {
        Room room = sessionFactory.getCurrentSession().get(Room.class, id);
        if (room != null)  {
            this.sessionFactory.getCurrentSession().delete(room);
        }
    }

    public Room update(Room item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public Room get(Integer id) {
        return sessionFactory.getCurrentSession().get(Room.class, id);
    }
}
