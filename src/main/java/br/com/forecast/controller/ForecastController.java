package br.com.forecast.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.forecast.dto.CityForecastDto;
import br.com.forecast.service.ForecastService;

@RestController
public class ForecastController {
	
	@Autowired
	ForecastService forecastService;
	
	@RequestMapping(value="/weather/{id}",method = RequestMethod.GET)
	public ResponseEntity<CityForecastDto> weather(@PathVariable(value= "id") long id) {
		CityForecastDto cityForecast = forecastService.verify(id);
			if(Objects.nonNull(cityForecast)) {
				return new ResponseEntity<CityForecastDto>(cityForecast,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
