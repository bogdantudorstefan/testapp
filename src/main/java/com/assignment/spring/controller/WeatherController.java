package com.assignment.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.spring.domain.DTO.WeatherEntityDTO;
import com.assignment.spring.service.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherEntityDTO weather(@RequestParam(required = true) String city) {
        return weatherService.logWeather(city);
    }
    
    @GetMapping("/weatherHistory")
    public List<WeatherEntityDTO> weatherHistory(@RequestParam(required = true) String city) {
        return weatherService.getHistoryByCity(city);
    }

}
