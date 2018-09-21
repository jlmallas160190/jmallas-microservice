/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmallas.repository.controller;

import com.jmallas.repository.data.SortOrder;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

/**
 *
 * @author jorgemalla
 * @param <T>
 * @param <ID>
 */
public class SimpleJpaRepository<T, ID extends Serializable> extends PersistenceRepository<T> implements JpaRepository<T, ID> {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        setEntityManager(em);
    }

    @Override
    protected String getPersistenceContextName() {
        return "jmallasPU";
    }

    @Override
    public <E> List<E> findAll(final Class<E> type) {
        CriteriaQuery<E> query = getEntityManager().getCriteriaBuilder().createQuery(type);
        query.from(type);
        return getEntityManager().createQuery(query).getResultList();
    }

    protected <E> E findById(final Class<E> type, final Long id) throws NoResultException {
        Class<?> clazz = getObjectClass(type);
        E result = (E) getEntityManager().find(clazz, id);
        if (result == null) {
            throw new NoResultException("No object of type: " + type + " with ID: " + id);
        }
        return result;
    }

    protected Class<?> getObjectClass(final Object type) throws IllegalArgumentException {
        Class<?> clazz = null;
        if (type == null) {
            throw new IllegalArgumentException("Null has no type. You must pass an Object");
        } else if (type instanceof Class<?>) {
            clazz = (Class<?>) type;
        } else {
            clazz = type.getClass();
        }
        return clazz;
    }

    public List<T> findAll(SortOrder sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<T> findAll(Iterable<ID> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <S extends T> List<S> save(Iterable<S> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void flush() {
        this.em.flush();
    }

    @Transactional
    public <S extends T> S saveAndFlush(S entity, ID id) {
        S result = this.save(entity, id);
        this.flush();
        return result;
    }

    public void deleteInBatch(Iterable<T> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getOne(ID id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <S extends T> S save(S entity, ID id) {
        if (id == null) {
            this.em.persist(entity);
            return entity;
        } else {
            return this.em.merge(entity);
        }
    }

}
