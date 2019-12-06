package de.com.heycar.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.com.heycar.website.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>  {

	@Query(value = "select c from Car c where "
			+ "(((:make is not NULL) and (c.make = :make)) or ((:make is NULL) and (1=1))) and "
			+ "(((:model is not NULL) and (c.model = :model)) or ((:model is NULL) and (1=1))) and "
			+ "(((:year is not 0) and (c.year = :year)) or ((:year is 0) and (1=1))) and "
			+ "(((:color is not NULL) and (c.color = :color)) or ((:color is NULL) and (1=1))) ")
	List<Car> findCars(@Param("make") String make, 
						   @Param("model") String model,
						   @Param("year") int year,
						   @Param("color") String color);
	
	List<Car> findByListingId(Long id);

	@Query(value = "select c from Car c where c.code = :code and c.id = :id ")
	Car findByCodeAndListing(@Param("code") int code,
							 @Param("id") Long id);
}
