/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmallas.repository.controller;

import com.jmallas.repository.data.SortOrder;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jorgemalla
 * @param <T>
 * @param <ID>
 */
public interface JpaRepository<T extends Object, ID extends Serializable> {

    public <E> List<E> findAll(final Class<E> type);

    public List<T> findAll(SortOrder sort);

    public List<T> findAll(Iterable<ID> itrbl);

    public <S extends T> List<S> save(Iterable<S> itrbl);

    public void flush();

    public <S extends T> S saveAndFlush(S s, ID id);

    public void deleteInBatch(Iterable<T> itrbl);

    public void deleteAllInBatch();

    public T getOne(ID id);

    <S extends T> S save(S var1, ID id);
}
