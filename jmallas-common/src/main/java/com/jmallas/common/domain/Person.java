package com.jmallas.common.domain;

import com.jmallas.repository.domain.AbstractExternalIdentifiableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@Entity
@XmlRootElement
public class Person extends AbstractExternalIdentifiableEntity {

    private String identification;
}
