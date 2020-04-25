package br.com.forecast.entity;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@Getter
@Setter
@Table(name="city_forecast")
@NoArgsConstructor
@AllArgsConstructor
public class CityForecast implements Serializable {

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

	@PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dateCity = atual;
    }
}
