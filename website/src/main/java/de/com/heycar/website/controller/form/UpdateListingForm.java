package de.com.heycar.website.controller.form;

import de.com.heycar.website.model.Car;

public class UpdateListingForm {

	private Long id;
	private int code;
	private String make;
	private String model;
	private int power;
	private int year;
	private String color;
	private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Car atualizar(Car car) {
		car.setMake(this.getMake());
		car.setModel(this.getModel());
		car.setPower(this.getPower());
		car.setYear(this.getYear());
		car.setPrice(this.getPrice());
		
		return car;
	}	
	

}
