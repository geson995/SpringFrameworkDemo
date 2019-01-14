package com.springmvc.dao.common;

import java.util.List;

public interface IOperations<T, E> {
    T findOne(final E id);

    List findAll();

    void save(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final E id);
}
