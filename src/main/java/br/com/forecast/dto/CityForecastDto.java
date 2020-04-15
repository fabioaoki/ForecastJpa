package br.com.forecast.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="city_forecast")
public class CityForecastDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "name nao pode ser vazio")
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotEmpty(message = "city nao pode ser vazio")
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "date_city")
	private Date dateCity;

	public CityForecastDto() {
	}
	
	@PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dateCity = atual;
    }

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
