package com.assignment.spring.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignment.spring.clients.OpenweathermapClient;
import com.assignment.spring.domain.WeatherEntity;
import com.assignment.spring.domain.DTO.WeatherEntityDTO;
import com.assignment.spring.domain.openweathermapapi.Main;
import com.assignment.spring.domain.openweathermapapi.Sys;
import com.assignment.spring.domain.openweathermapapi.WeatherResponse;
import com.assignment.spring.exceptions.OpenweathermapComExcepion;
import com.assignment.spring.repository.WeatherRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherServiceTest {

	@InjectMocks
	WeatherService weatherService;
	
	@Mock
	OpenweathermapClient openweathermapClient;
	
	@Mock
    WeatherRepository weatherRepository;
	
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
	@Test
	public void logWeatherExceptionTest() {
		when(openweathermapClient.getCurrentWeatherDataByCity(any())).thenReturn(Optional.empty());
        thrown.expect(OpenweathermapComExcepion.class);
        weatherService.logWeather("Bratislava");
	}
	
	@Test
	public void logWeatherTest() {
		WeatherResponse mockWeatherResponse = WeatherResponse
				.builder()
				.name("Bucharest")
				.sys(Sys.builder().country("RO").build())
				.main(Main.builder().temp(10d).build())
				.build();
		WeatherEntity mockWeatherEntity = WeatherEntity.builder().city("Bucharest").country("RO").temperature(10d).build();
		when(openweathermapClient.getCurrentWeatherDataByCity(any())).thenReturn(Optional.of(mockWeatherResponse));
		when(weatherRepository.save(any())).thenAnswer(new Answer<WeatherEntity>() {
    	    @Override
    	    public WeatherEntity answer(InvocationOnMock invocation) throws Throwable {
    	      Object[] args = invocation.getArguments();
    	      WeatherEntity paramerer = (WeatherEntity) args[0];
    	      Assert.assertEquals(paramerer, mockWeatherEntity);
    	      mockWeatherEntity.setId(1);
    	      return mockWeatherEntity;
    	    }
		});
	   WeatherEntityDTO expected = WeatherEntityDTO.builder().city("Bucharest").country("RO").temperature(10d).build();
	   Assert.assertEquals(expected, weatherService.logWeather("Bucharest"));
	}
	
}
