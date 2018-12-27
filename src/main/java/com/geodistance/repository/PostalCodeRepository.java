package com.geodistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geodistance.entities.PostalCode;

/**
 * Repository interface, which extends JpaRepository.
 * @author Marija
 *
 */
@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCode, Integer> {

	PostalCode getByPostcode(String postcode);
}
