package com.jmallas.common.sevice;

import com.jmallas.common.domain.Person;
import com.jmallas.common.repository.PersonRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll(Person.class);
    }

}
