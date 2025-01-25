package com.dk.myownecommerce.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "PK_ID", length = 36, nullable = false, unique = true)
    private String id;

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDateTime createdDate;


    @LastModifiedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastModifiedDate;


    @Column(name = "deleted")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deletedDate;

    protected BaseEntity() {
        LocalDateTime now = LocalDateTime.now(); // Sadece bir kez çağırıyoruz
        this.id = UUID.randomUUID().toString();
        this.createdDate = now;
        this.lastModifiedDate = now; // Aynı milisaniyeyi kullanıyoruz
    }

    protected void setId(String id) {
        this.id = id;
    }
}