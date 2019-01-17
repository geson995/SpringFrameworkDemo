package com.springmvc.dao.common;

public abstract class AbstractDao<T, E> implements IOperations<T, E> {
    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }


}
