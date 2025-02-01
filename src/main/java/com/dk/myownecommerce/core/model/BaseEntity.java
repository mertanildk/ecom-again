package com.dk.myownecommerce.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "PK_ID", length = 36, nullable = false, unique = true)
    private String id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Column(name = "deleted")
    private LocalDateTime deletedDate;

    protected BaseEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }
}