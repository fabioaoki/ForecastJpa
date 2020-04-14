package br.com.forecast.service;

import java.util.ArrayList;
import java.util.List;

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

	public CityForecastDto newCity(CityForecastDto cityForecastDto) {
		CityForecastDto retorno = cityForecastDto;
		retorno.prePersist();
		cityForecastRepository.save(retorno);
		return retorno;
	}

	public ArrayList<CityForecastDto> getAll() {
		ArrayList<CityForecastDto> retorno = (ArrayList<CityForecastDto>) cityForecastRepository.findAll();
		return  retorno;
	}
}
