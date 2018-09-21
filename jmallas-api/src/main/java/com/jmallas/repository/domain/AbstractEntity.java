package com.jmallas.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {
    @Column(updatable = false)
    private Timestamp created;

    @Version
    @Column(updatable = true)
    private Timestamp updated;

    @PrePersist
    public void createAt() {
        created = new Timestamp(System.currentTimeMillis());
    }
}
