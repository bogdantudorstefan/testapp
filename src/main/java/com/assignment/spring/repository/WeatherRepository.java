package com.assignment.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.spring.domain.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {
	
	List<WeatherEntity> findAllByCityOrderByCreationDate(String city);
}
