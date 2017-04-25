package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.ReviewDAO;
import com.aliaksey.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public class ReviewDAOImpl implements ReviewDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Review item) {
        sessionFactory.getCurrentSession().persist(item);
    }

    public List<Review> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Review> reviews = session.createQuery("from Review").list();
        return reviews;
    }

    public void delete(Integer id) {
        Review review = sessionFactory.getCurrentSession().get(Review.class, id);
        if (review != null)  {
            this.sessionFactory.getCurrentSession().delete(review);
        }
    }

    public Review update(Review item) {
        return null;
    }

    public Review get(Integer id) {
        return sessionFactory.getCurrentSession().get(Review.class, id);
    }
}
