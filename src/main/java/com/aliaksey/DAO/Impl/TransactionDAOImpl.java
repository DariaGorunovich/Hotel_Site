package com.aliaksey.DAO.Impl;

import com.aliaksey.DAO.TransactionDAO;
import com.aliaksey.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public class TransactionDAOImpl implements TransactionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Transaction item) {
        sessionFactory.getCurrentSession().persist(item);
    }

    public List<Transaction> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Transaction> transactions = session.createQuery("from Transaction").list();
        return transactions;
    }

    public void delete(Integer id) {
        Transaction transaction = sessionFactory.getCurrentSession().get(Transaction.class, id);
        if (transaction != null)  {
            this.sessionFactory.getCurrentSession().delete(transaction);
        }
    }

    public Transaction update(Transaction item) {
        return null;
    }

    public Transaction get(Integer id) {
        return sessionFactory.getCurrentSession().get(Transaction.class, id);
    }
}
