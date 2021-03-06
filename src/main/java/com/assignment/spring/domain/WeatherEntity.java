package com.assignment.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "weather")
public class WeatherEntity extends Loggable{

    @Id
    @GeneratedValue(generator = "weatherEntityIdSequence")
    @SequenceGenerator(name = "weatherEntityIdSequence", sequenceName = "weatherEntityIdSequence", allocationSize = 1)
    private Integer id;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "country", nullable = false)
    private String country;
    
    @Column(name = "temperature", nullable = false)
    private Double temperature;

}
