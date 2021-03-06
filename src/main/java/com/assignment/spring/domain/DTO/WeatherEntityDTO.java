package com.assignment.spring.domain.DTO;

import java.util.Date;

import com.assignment.spring.domain.WeatherEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntityDTO {

    private String city;
    private String country;
    private Double temperature;
    private Date date;
	
    public WeatherEntityDTO(WeatherEntity weatherEntity) {
    	city = weatherEntity.getCity();
    	country = weatherEntity.getCountry();
    	temperature = weatherEntity.getTemperature();
    	date = weatherEntity.getCreationDate();
    }
}
