package com.jmallas.common.repository;

import com.jmallas.common.domain.Person;
import com.jmallas.repository.controller.SimpleJpaRepository;

import javax.ejb.Stateless;

@Stateless
public class PersonRepository extends SimpleJpaRepository<Person, Long> {
}
