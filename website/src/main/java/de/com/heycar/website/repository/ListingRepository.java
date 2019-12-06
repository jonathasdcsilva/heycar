package de.com.heycar.website.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.com.heycar.website.model.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {

	List<Listing> findByDealerId(Long id);

	Optional<Listing> findById(Long id);
	
}
