package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.ReservationDAO;
import com.aliaksey.entity.Reservation;
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
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Reservation item) {
        sessionFactory.getCurrentSession().persist(item);
    }

    public List<Reservation> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Reservation> reservationList = session.createQuery("from Reservation").list();
        return reservationList;
    }

    public void delete(Integer id) {
        Reservation reservation = sessionFactory.getCurrentSession().get(Reservation.class, id);
        if (reservation != null)  {
            this.sessionFactory.getCurrentSession().delete(reservation);
        }
    }

    public Reservation update(Reservation item) {
        return null;
    }

    public Reservation get(Integer id) {
        return sessionFactory.getCurrentSession().get(Reservation.class, id);
    }
}
