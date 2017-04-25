package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.RoleDAO;
import com.aliaksey.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Role item) {
        sessionFactory.getCurrentSession().persist(item);
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
        return null;
    }

    public Role get(Integer id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }
}
