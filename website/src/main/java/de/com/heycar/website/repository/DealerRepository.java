package de.com.heycar.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.com.heycar.website.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
