package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.RoleDAO;
import com.aliaksey.entity.Role;
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
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Role item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<Role> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Role> roles = session.createQuery("from Role").list();
        return roles;
    }

    public void delete(Integer id) {
        Role role = sessionFactory.getCurrentSession().get(Role.class, id);
        if (role != null)  {
            this.sessionFactory.getCurrentSession().delete(role);
        }
    }

    public Role update(Role item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public Role get(Integer id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }
}
