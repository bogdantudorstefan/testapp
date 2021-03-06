package com.assignment.spring.utils;

import com.assignment.spring.domain.WeatherEntity;
import com.assignment.spring.domain.openweathermapapi.WeatherResponse;

public class Mappers {
	
	private Mappers() {
		throw new IllegalStateException("Utility class");
	}

	public static WeatherEntity toWeatherEntity(WeatherResponse weatherResponse) {
		return WeatherEntity.builder()
								.city(weatherResponse.getName())
								.country(weatherResponse.getSys().getCountry())
								.temperature(weatherResponse.getMain().getTemp())
								.build();
	}
	
}
