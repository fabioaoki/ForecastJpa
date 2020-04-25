package br.com.forecast.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

import br.com.forecast.dto.CityForecastDto;
import br.com.forecast.responses.Response;
import br.com.forecast.service.ForecastService;

@RestController
public class ForecastController {

	@Autowired
	ForecastService forecastService;

	@RequestMapping(value="/weather/{id}",method = RequestMethod.GET)
	public ResponseEntity<CityForecastDto> weather(@PathVariable(value= "id") long id) {
		CityForecastDto cityForecastDto = forecastService.verify(id);
		if(Objects.nonNull(cityForecastDto)) {
			return new ResponseEntity<CityForecastDto>(cityForecastDto,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/weather/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<CityForecastDto> delete(@PathVariable(value= "id") long id) {
		try {
			forecastService.delete(id);
			return new ResponseEntity<CityForecastDto>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Preciso de ajuda  para melhorar esse codigo	
	@RequestMapping(value="/weather", method =  RequestMethod.GET)
	public ResponseEntity<List<CityForecastDto>> allCity(){
		List<CityForecastDto> listCityForecastDto = forecastService.getAll();
		if(Objects.nonNull(listCityForecastDto)) {
			return new ResponseEntity<List<CityForecastDto>>(listCityForecastDto, HttpStatus.OK);
		}
		return new ResponseEntity<List<CityForecastDto>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/weather",method = RequestMethod.POST)
	public ResponseEntity<Response<CityForecastDto>> newCity(@Valid @RequestBody CityForecastDto cityForecastDto, 
			BindingResult result){
		Response<CityForecastDto> response = new Response<CityForecastDto>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return new ResponseEntity<Response<CityForecastDto>>(response,HttpStatus.BAD_REQUEST);
		}
		response.setData(forecastService.newCity(cityForecastDto));
		return new ResponseEntity<Response<CityForecastDto>>(response,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/weather/{id}",method = RequestMethod.PUT)
	public ResponseEntity<CityForecastDto> alterInformation(@PathVariable (value = "id") long id, 
			@RequestBody CityForecastDto cityForecastDto){
		
		CityForecastDto dto = forecastService.verify(id);
		if(Objects.nonNull(dto)){
			cityForecastDto.setId(id);
			if(Strings.isNullOrEmpty(cityForecastDto.getName())) {
				cityForecastDto.setName(dto.getName());
			}
			if(Strings.isNullOrEmpty(cityForecastDto.getCity())) {
				cityForecastDto.setCity(dto.getCity());
			}
			forecastService.save(cityForecastDto);
			return new ResponseEntity<CityForecastDto>(cityForecastDto,HttpStatus.OK);
		}
		return new ResponseEntity<CityForecastDto>(HttpStatus.BAD_REQUEST);
	}
	
}

