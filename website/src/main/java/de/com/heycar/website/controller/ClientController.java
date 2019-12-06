package de.com.heycar.website.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.com.heycar.website.controller.dto.ListingCarDto;
import de.com.heycar.website.model.Car;
import de.com.heycar.website.repository.CarRepository;

@RestController
public class ClientController {

	@Autowired
	private CarRepository carRepository;

	@RequestMapping("/client")
	public ResponseEntity<List<ListingCarDto>> carListing(@RequestParam(required = true) String make, @RequestParam(required = true) String model,
			@RequestParam(required = true) String year, @RequestParam(required = true) String color){
		
		int yearParam = year.equals("") ? 0 : Integer.parseInt(year);
		make = make.equals("") ? null : make;
		model = model.equals("") ? null : model;
		color = color.equals("") ? null : color;
		
		List<Car> cars = carRepository.findCars(make, model, yearParam, color);
		
		if(!cars.isEmpty()) {
			List<ListingCarDto> alListingcarDto = new ArrayList<>();
			alListingcarDto.addAll(cars.stream().map(ListingCarDto::new).collect(Collectors.toList()));
			
			return ResponseEntity.ok(alListingcarDto);
		}
		return ResponseEntity.notFound().build();
	}

}
