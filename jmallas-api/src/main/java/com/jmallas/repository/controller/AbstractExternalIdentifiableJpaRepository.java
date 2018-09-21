/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmallas.repository.controller;

import com.jmallas.repository.domain.AbstractIdentifiableEntity;
import java.io.Serializable;

/**
 *
 * @author jorgemalla
 * @param <T>
 * @param <ID>
 */
public interface AbstractExternalIdentifiableJpaRepository<T extends AbstractIdentifiableEntity, ID extends Serializable>  extends JpaRepository<T, ID> {
    T findOneByExternalId(String externalId);
}
