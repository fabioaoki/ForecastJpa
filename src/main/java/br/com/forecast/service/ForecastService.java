package br.com.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.forecast.dto.CityForecastDto;
import br.com.forecast.repository.CityForecastRepository;

@Service
public class ForecastService  {
	
	@Autowired
	CityForecastRepository cityForecastRepository;

	public CityForecastDto verify(long id) {
		CityForecastDto retorno = cityForecastRepository.findById(id);
		return retorno;
	}
}
