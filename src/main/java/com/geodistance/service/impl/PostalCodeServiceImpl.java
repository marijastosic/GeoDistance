package com.geodistance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geodistance.entities.PostalCode;
import com.geodistance.repository.PostalCodeRepository;
import com.geodistance.service.PostalCodeService;

@Transactional
@Service
public class PostalCodeServiceImpl implements PostalCodeService {
	
	@Autowired
	private PostalCodeRepository postalCodeRepository;

	@Override
	public PostalCode getByPostcode(String postcode) {
		return postalCodeRepository.getByPostcode(postcode);
	}
}
