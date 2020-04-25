package br.com.forecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.forecast.entity.CityForecast;

public interface CityForecastRepository extends JpaRepository<CityForecast, Long> {
	
	CityForecast findById(long id);
	
}
