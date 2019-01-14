package com.springmvc.dao.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractHibernateDao<T, E> extends AbstractDao<T, E> implements IOperations<T, E> {
    @Autowired
    protected SessionFactory sessionFactory;

    @Override
//    @Transactional
    public T findOne(final E id) {
        return (T) getCurrentSession().find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("from" + clazz.getName()).list();
    }

    @Override
    public void save(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(final E id) {
        final T entity = findOne(id);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
