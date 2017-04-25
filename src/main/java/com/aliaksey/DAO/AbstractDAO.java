package com.aliaksey.DAO;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aliaksey on 25.04.2017.
 */
public interface AbstractDAO<T> {

    public void add(T item);

    public List<T> getAll();

    public void delete(Integer id);

    public T update(T item);

    public T get(Integer id);
}
