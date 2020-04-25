package br.com.forecast.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityForecastDto implements Serializable {

	private static final long serialVersionUID = -6978454629460201327L;
	
	private Long id;
	private String name;
	private String city;
	private Date dateCity;

}
