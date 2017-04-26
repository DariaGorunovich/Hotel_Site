package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.RestroomTypeDAO;
import com.aliaksey.entity.RestroomType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */

@Repository
@Transactional
public class RestroomTypeDAOImpl implements RestroomTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(RestroomType item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<RestroomType> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<RestroomType> restroomTypes = session.createQuery("from RestroomType").list();
        return restroomTypes;
    }

    public void delete(Integer id) {
        RestroomType restroomType = sessionFactory.getCurrentSession().get(RestroomType.class, id);
        if (restroomType != null)  {
            this.sessionFactory.getCurrentSession().delete(restroomType);
        }
    }

    public RestroomType update(RestroomType item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public RestroomType get(Integer id) {
        return sessionFactory.getCurrentSession().get(RestroomType.class, id);
    }
}
