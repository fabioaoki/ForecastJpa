package br.com.forecast.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="city_forecast")
public class CityForecastDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String city;
	
	private Date dateCity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateCity() {
		return dateCity;
	}

	public void setDateCity(Date dateCity) {
		this.dateCity = dateCity;
	}

	@Override
	public String toString() {
		return "CityForecastDto [id=" + id + ", name=" + name + ", city=" + city + ", dateCity=" + dateCity + "]";
	}

	
}
