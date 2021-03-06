package com.assignment.spring.clients;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.assignment.spring.domain.openweathermapapi.WeatherResponse;

public class OpenweathermapClient {

	static final Logger LOGGER = LoggerFactory.getLogger(OpenweathermapClient.class);

	@Value("${openweathermap.appkey}")
	private String apiKey;
	
	@Value("${openweathermap.url}")
	private String openweathermapUrl;

    @Autowired
    private RestTemplate restTemplate;
    
	@Retryable(maxAttempts = 3, value = Exception.class, backoff = @Backoff(delay = 1000))
	public Optional<WeatherResponse> getCurrentWeatherDataByCity(String city) {
		URI uri = UriComponentsBuilder.fromHttpUrl(openweathermapUrl)
				.queryParam("q", city)
				.queryParam("apiKey", apiKey)
				.build().encode().toUri();
		try {
			return Optional.of(restTemplate.getForEntity(uri, WeatherResponse.class).getBody());
		} catch (Exception e) {
			LOGGER.error("Error when trying to fetch data from weather API: {}", e.getMessage());
			return Optional.empty();
		}
	}
	
}
