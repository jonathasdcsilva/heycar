package de.com.heycar.website.controller.form;

import java.time.LocalDateTime;
import java.util.Optional;

import de.com.heycar.website.model.Car;
import de.com.heycar.website.model.Dealer;
import de.com.heycar.website.model.Listing;
import de.com.heycar.website.repository.DealerRepository;

public class ListingForm {

	private Long idDealer;
	private int code;
	private String make;
	private String model;
	private int power;
	private int year;
	private String color;
	private double price;
	
	public Long getIdDealer() {
		return idDealer;
	}

	public void setIdDealer(Long idDealer) {
		this.idDealer = idDealer;
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

	public Listing convertFormToListing(DealerRepository dealerRepository) {
		Optional<Dealer> dealer = dealerRepository.findById(idDealer);
		return new Listing(LocalDateTime.now(), dealer.get());
	}

	public Car convertFormToCar(Listing listing) {
		return new Car(this.getCode(), this.getMake(), this.getModel(), this.getPower(),this.getYear(), this.getColor(), this.getPrice(), listing);
	}
}
