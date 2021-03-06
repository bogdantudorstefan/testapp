package com.assignment.spring.domain;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class LoggableListener {

    @PrePersist
    void prePersist(Loggable loggable) {

        Date currentDate = new Date();
        loggable.setCreatedBy(getUser());
        loggable.setCreationDate(currentDate);
        loggable.setLastUpdatedBy(getUser());
        loggable.setLastUpdateDate(currentDate);
    }

    @PreUpdate
    void preUpdate(Loggable loggable) {

        Date currentDate = new Date();
        loggable.setLastUpdatedBy(getUser());
        loggable.setLastUpdateDate(currentDate);
    }

    private String getUser() {
//    	This must be determined from a logging mechanism
        return "logged_user";
    }

}