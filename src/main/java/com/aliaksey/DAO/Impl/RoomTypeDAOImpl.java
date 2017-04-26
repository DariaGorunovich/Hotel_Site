package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.RoomTypeDAO;
import com.aliaksey.entity.RoomType;
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
public class RoomTypeDAOImpl implements RoomTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(RoomType item) {
        sessionFactory.getCurrentSession().persist(item);
    }

    public List<RoomType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<RoomType> roomTypes = session.createQuery("from RoomType").list();
        return roomTypes;
    }

    public void delete(Integer id) {
        RoomType roomType = sessionFactory.getCurrentSession().get(RoomType.class, id);
        if (roomType != null)  {
            this.sessionFactory.getCurrentSession().delete(roomType);
        }
    }

    public RoomType update(RoomType item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public RoomType get(Integer id) {
        return sessionFactory.getCurrentSession().get(RoomType.class, id);
    }
}
