package br.com.forecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.forecast.dto.CityForecastDto;

public interface CityForecastRepository extends JpaRepository<CityForecastDto, Long> {
	
	CityForecastDto findById(long id);
	
}
