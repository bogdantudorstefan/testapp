package com.assignment.spring.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(LoggableListener.class)
public class Loggable {

    @CreatedDate
    @Column(name = "created", nullable = false)
    private Date creationDate;

    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "last_modified", nullable = false)
    private Date lastUpdateDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = false)
    private String lastUpdatedBy;

}