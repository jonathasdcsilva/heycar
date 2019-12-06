package de.com.heycar.website.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.com.heycar.website.model.Listing;

public class ListingDealerDto {

	private Long id;
	private String nameDealer;
	private LocalDateTime uploadDate;
	private List<CarDto> car;
		
	public ListingDealerDto(Listing listing) {
		this.id = listing.getId();
		this.uploadDate = listing.getUploadDate();
		this.nameDealer = listing.getDealer().getName();
		
		this.car = new ArrayList<>(); 
		this.car.addAll(listing.getCar().stream().map(CarDto::new).collect(Collectors.toList()));
	}
	
	public ListingDealerDto(List<Listing> listing) {
		
	}
	
	public ListingDealerDto() {
 
	}

	public Long getId() {
		return id;
	}
	
	public String getNameDealer() {
		return nameDealer;
	}
	
	public LocalDateTime getUploadDate() {
		return uploadDate;
	}

	public List<CarDto> getCar() {
		return car;
	}
}
