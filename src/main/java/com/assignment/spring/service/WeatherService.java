package com.assignment.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.spring.clients.OpenweathermapClient;
import com.assignment.spring.domain.WeatherEntity;
import com.assignment.spring.domain.DTO.WeatherEntityDTO;
import com.assignment.spring.domain.openweathermapapi.WeatherResponse;
import com.assignment.spring.exceptions.OpenweathermapComExcepion;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.utils.Mappers;

@Service
public class WeatherService {

	@Autowired
	OpenweathermapClient openweathermapClient;
	
    @Autowired
    private WeatherRepository weatherRepository;
    
	public WeatherEntityDTO logWeather(String city) {
		WeatherResponse weatherResponse = openweathermapClient.getCurrentWeatherDataByCity(city)
				.orElseThrow(() -> new OpenweathermapComExcepion("Cannot access weather source"));
		WeatherEntity weatherEntity = weatherRepository.save(Mappers.toWeatherEntity(weatherResponse));
		return new WeatherEntityDTO(weatherEntity);
	}
	
	public List<WeatherEntityDTO> getHistoryByCity(String city) {
		return weatherRepository.findAllByCityOrderByCreationDate(city)
				.stream().map(WeatherEntityDTO::new)
				.collect(Collectors.toList());
	}

}