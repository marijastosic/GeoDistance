package com.geodistance.service;

import java.util.List;

import com.geodistance.entities.PostalCode;

/**
 * Interface with all necessary methods for comunicating with database.
 * @author Marija
 *
 */
public interface PostalCodeService {

	public PostalCode getByPostcode(String postcode);
	public List<PostalCode> getAllPostalCodes();
	public PostalCode getById(Integer id);
	public PostalCode save(PostalCode postalCode);
	public void delete(Integer id);
}
