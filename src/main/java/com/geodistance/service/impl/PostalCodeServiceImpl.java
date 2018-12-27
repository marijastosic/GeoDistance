package com.geodistance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geodistance.entities.PostalCode;
import com.geodistance.repository.PostalCodeRepository;
import com.geodistance.service.PostalCodeService;

/**
 * Imlementation class for PostalCodeService interface.
 * @author Marija
 *
 */
@Transactional
@Service
public class PostalCodeServiceImpl implements PostalCodeService {
	
	@Autowired
	private PostalCodeRepository postalCodeRepository;

	@Override
	public PostalCode getByPostcode(String postcode) {
		return postalCodeRepository.getByPostcode(postcode);
	}

	@Override
	public List<PostalCode> getAllPostalCodes() {
		return postalCodeRepository.findAll();
	}

	@Override
	public PostalCode getById(Integer id) {
		return postalCodeRepository.getOne(id);
	}

	@Override
	public PostalCode save(PostalCode postalCode) {
		return postalCodeRepository.save(postalCode);
	}

	@Override
	public void delete(Integer id) {
		postalCodeRepository.deleteById(id);
	}
}
