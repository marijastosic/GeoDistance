package com.geodistance.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.geodistance.data.GeoDistanceResponse;
import com.geodistance.entities.PostalCode;
import com.geodistance.service.PostalCodeService;

/**
 * Class for testing rest services.
 * @author Marija
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PostalCodeRestControllerTest {
	
	@InjectMocks
	private PostalCodeRestController postalCodeRestController;
	
	@Mock
	private PostalCodeService postalCodeService;
	
	private PostalCode postalCode1;
	private PostalCode postalCode2;
	
	/**
	 * Setting up data in objects which will be used in tests.
	 * This method will execute before all tests.
	 */
	@Before
	public void setup() {
		postalCode1 = new PostalCode(0, "KK22 3NB", 45.15478741, -2.45647498);
		postalCode2 = new PostalCode(1, "KK23 4OS", 45.15178741, -3.45647498);
	}
	
	/**
	 * Method for testing getDistance() rest service. Distances should be equals.
	 */
	@Test
	public void getDistanceTest() {		
		when(postalCodeService.getByPostcode("KK22 3NB")).thenReturn(postalCode1);
		when(postalCodeService.getByPostcode("KK23 4OS")).thenReturn(postalCode2);
		
		GeoDistanceResponse expected = new GeoDistanceResponse(postalCode1, postalCode2);
		GeoDistanceResponse result = postalCodeRestController.getDistance(postalCode1.getPostcode(), postalCode2.getPostcode());
		
		assertEquals(expected.getDistance(), result.getDistance(), 0.001);
	}
}
