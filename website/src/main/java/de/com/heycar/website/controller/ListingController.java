package de.com.heycar.website.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import de.com.heycar.website.controller.dto.ListingDealerDto;
import de.com.heycar.website.controller.form.ListingForm;
import de.com.heycar.website.controller.form.UpdateListingForm;
import de.com.heycar.website.model.Car;
import de.com.heycar.website.model.Listing;
import de.com.heycar.website.repository.CarRepository;
import de.com.heycar.website.repository.DealerRepository;
import de.com.heycar.website.repository.ListingRepository;

@RestController
@RequestMapping("/listing")
public class ListingController {
	
	@Autowired
	private ListingRepository listingRepository;
	
	@Autowired
	private DealerRepository dealerRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<ListingDealerDto>> listingDealer(@PathVariable Long id){
		List<Listing> listing = listingRepository.findByDealerId(id);
		
		if(!listing.isEmpty()) {
			List<ListingDealerDto> alListingDealerDto = new ArrayList<>();
			alListingDealerDto.addAll(listing.stream().map(ListingDealerDto::new).collect(Collectors.toList()));
			
			return ResponseEntity.ok(alListingDealerDto);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<ListingDealerDto> insertListing(@RequestBody List<ListingForm> listingForm, UriComponentsBuilder uriBuilder) {
		
		Listing listing = null;
		
		if(listingForm.size() > 1) {
		
			listing = saveListing(listingForm);
			
			for (ListingForm listForm : listingForm) {
				
				saveCar(listing, listForm);
			}
			
		} else if (listingForm.size() == 1 ){
			listing = saveListing(listingForm);
			
			saveCar(listing,  listingForm.get(0));
		} else {
			return ResponseEntity.notFound().build();
		}
		
		URI uri = uriBuilder.path("/listing/{id}").buildAndExpand(listing.getDealer().getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ListingDealerDto(listing));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ListingDealerDto> updateListing(@PathVariable Long id, @RequestBody List<UpdateListingForm> updateForm) {
		
		Listing listing = listingRepository.getOne(id);
		ListingDealerDto listingDealerDto = new ListingDealerDto();
		
		if(listing.getId() > 0) {
			
			if(updateForm.size() == 1) {
				
				Car car = findCar(updateForm.get(0));
				
				if(car.getId() > 0) {
					updateCar(updateForm.get(0), car); 
				}
				listingDealerDto = new ListingDealerDto(listing);
				
			} if (updateForm.size() > 1) {
				
				for (UpdateListingForm updateListingForm : updateForm) {
					Car car = findCar(updateListingForm);
					if(car.getId() > 0) {
						updateCar(updateListingForm, car); 
					}
				}
				listingDealerDto = new ListingDealerDto(listing);
			}
			
			return ResponseEntity.ok(listingDealerDto);
			
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

	private void updateCar(UpdateListingForm updateListingForm, Car car) {
		car.setMake(updateListingForm.getMake());
		car.setModel(updateListingForm.getModel());
		car.setPower(updateListingForm.getPower());
		car.setYear(updateListingForm.getYear());
		car.setColor(updateListingForm.getColor());
		car.setPrice(updateListingForm.getPrice());
	}

	private Car findCar(UpdateListingForm updateListingForm) {
		Car car = carRepository.findByCodeAndListing(updateListingForm.getCode(), updateListingForm.getId());
		return car;
	}

	private void saveCar(Listing listing, ListingForm listForm) {
		Car car = listForm.convertFormToCar(listing);
		carRepository.save(car);
	}

	private Listing saveListing(List<ListingForm> listingForm) {
		Listing listing;
		listing = listingForm.get(0).convertFormToListing(dealerRepository);
		listingRepository.save(listing);
		return listing;
	}
}
