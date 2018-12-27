package com.geodistance.rest.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.regex.Matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.geodistance.data.GeoDistanceResponse;
import com.geodistance.entities.PostalCode;
import com.geodistance.service.PostalCodeService;

@RunWith(MockitoJUnitRunner.class)
public class PostalCodeRestControllerTest {

	@Mock
	private PostalCodeService postalCodeService;
	
	@InjectMocks
	private PostalCodeRestController postalCodeRestController;
	
	@Test
	public void getDistanceTest() {
		PostalCode postalCode1 = new PostalCode(0, "KK22 3NB", 45.15478741, -2.45647498);
		PostalCode postalCode2 = new PostalCode(1, "KK23 4OS", 45.15178741, -3.45647498);
		
		when(postalCodeService.getByPostcode("KK22 3NB")).thenReturn(postalCode1);
		when(postalCodeService.getByPostcode("KK23 4OS")).thenReturn(postalCode2);
		
		GeoDistanceResponse expected = new GeoDistanceResponse(postalCode1, postalCode2);
		GeoDistanceResponse result = postalCodeRestController.getDistance(postalCode1.getPostcode(), postalCode2.getPostcode());
		
		assertEquals(expected.getDistance(), result.getDistance(), 0.001);
	}
}
