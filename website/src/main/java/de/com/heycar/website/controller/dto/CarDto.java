package de.com.heycar.website.controller.dto;

import de.com.heycar.website.model.Car;

public class CarDto {

	private Long id;
	private int code;
	private String make;
	private String model;
	private int power;
	private int year;
	private String color;
	private double price;
	
	public CarDto(Car car) {
		this.id = car.getId();
		this.code = car.getCode();
		this.make = car.getMake();
		this.model = car.getModel();
		this.power = car.getPower();
		this.year = car.getYear();
		this.color = car.getColor();
		this.price = car.getPrice();
	}
	
	public Long getId() {
		return id;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getPrice() {
		return price;
	}
}
