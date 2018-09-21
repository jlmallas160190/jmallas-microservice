package com.jmallas.repository.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
@ToString(callSuper = true)
public abstract class AbstractExternalIdentifiableEntity extends AbstractIdentifiableEntity {

    @Column(length = 36)
    protected String externalId;

    @PrePersist
    public void initializeExternalId() {
        if (externalId == null) {
            externalId = UUID.randomUUID().toString();
        }
    }
}
