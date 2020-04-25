package br.com.forecast.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.forecast.dto.CityForecastDto;
import br.com.forecast.entity.CityForecast;
import br.com.forecast.repository.CityForecastRepository;

@Service
public class ForecastService  {

	@Autowired
	CityForecastRepository cityForecastRepository;

	public CityForecastDto verify(long id) {
		CityForecast cityForecast =  cityForecastRepository.findById(id);
		return CityForecastDto.builder().name(cityForecast.getName()).city(cityForecast.getCity()).dateCity(cityForecast.getDateCity()).id(cityForecast.getId()).build();
	}
	
	public List<CityForecastDto> getAll() {
		
		List<CityForecast> cityForecasts = cityForecastRepository.findAll();
		List<CityForecastDto> lisForecastDtos = new ArrayList<>();
		
		for (CityForecast cityForecast : cityForecasts) {
			lisForecastDtos.add(CityForecastDto.builder().name(cityForecast.getName()).city(cityForecast.getCity()).dateCity(cityForecast.getDateCity()).id(cityForecast.getId()).build());
		}
		return lisForecastDtos;
	} 
	
	public void delete(long id) {
		cityForecastRepository.deleteById(id);
	}

	public CityForecastDto newCity(@Valid CityForecastDto cityForecastDto) {
		CityForecast cityForecast = CityForecast.builder().id(cityForecastDto.getId()).name(cityForecastDto.getName()).city(cityForecastDto.getCity()).build();
		cityForecastRepository.save(cityForecast);
		return cityForecastDto;
	}

	public void save(CityForecastDto cityForecastDto) {
		CityForecast cityForecast = CityForecast.builder().id(cityForecastDto.getId()).name(cityForecastDto.getName()).city(cityForecastDto.getCity()).dateCity(cityForecastDto.getDateCity()).build();
		cityForecastRepository.save(cityForecast);
	}
}
