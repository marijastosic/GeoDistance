package com.geodistance.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geodistance.data.GeoDistanceResponse;
import com.geodistance.entities.PostalCode;
import com.geodistance.service.PostalCodeService;
import com.geodistance.util.GeoDistanceUtil;

@RestController
@RequestMapping("/postalcodes")
public class PostalCodeRestController {
	
	@Autowired
	private PostalCodeService postalCodeService;
	
	@GetMapping
	public ResponseEntity<List<PostalCode>> getAllPostalCodes(){
		return ResponseEntity.ok(postalCodeService.getAllPostalCodes());		
	}

	@RequestMapping(params = "postcode", method = RequestMethod.GET)
	public ResponseEntity<PostalCode> getPostalCodeByPostcode(@RequestParam(name = "postcode") String postcode) {
		PostalCode postalCode = postalCodeService.getByPostcode(postcode);
		
		if(postalCode != null) {
			return ResponseEntity.ok(postalCode);
		} else {
			return ResponseEntity.notFound().build();		
		}
	}
	
	@RequestMapping(params = "id", method = RequestMethod.GET)
	public ResponseEntity<PostalCode> getPostalCodeById(@RequestParam("id") Integer id) {
		PostalCode postalCode = postalCodeService.getById(id);
		
		if(postalCode != null) {
			return ResponseEntity.ok(postalCode);
		} else {
			return ResponseEntity.notFound().build();		
		}
	}
	
	@PostMapping
	public ResponseEntity<PostalCode> savePostalCode(@RequestBody PostalCode postalCode) {
		if(postalCode.getId() == null) {
			return ResponseEntity.ok(postalCodeService.save(postalCode));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<PostalCode> updatePostalCode(@RequestBody PostalCode postalCode) {
		if(postalCode.getId() == null) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(postalCodeService.save(postalCode));
		}
	}
	
	@DeleteMapping("/{id}")
	public void deletePostalCode(@PathVariable Integer id) {
		postalCodeService.delete(id);
	}
	
//	@GetMapping("/{postcode1}/{postcode2}")
//	public double getDistance(@PathVariable("postcode1") String postcode1, @PathVariable("postcode2") String postcode2) {
//		PostalCode postalCode1 = postalCodeService.getByPostcode(postcode1);
//		PostalCode postalCode2 = postalCodeService.getByPostcode(postcode2);
//		
//		return GeoDistanceUtil.calculateDistance(Double.valueOf(postalCode1.getLatitude()), Double.valueOf(postalCode1.getLongitude()), Double.valueOf(postalCode2.getLatitude()), Double.valueOf(postalCode2.getLongitude()));
//	}
	
	@GetMapping("/{postcode1}/{postcode2}")
	public GeoDistanceResponse getDistance(@PathVariable("postcode1") String postcode1, @PathVariable("postcode2") String postcode2) {
		PostalCode postalCode1 = postalCodeService.getByPostcode(postcode1);
		PostalCode postalCode2 = postalCodeService.getByPostcode(postcode2);
				
		GeoDistanceResponse response = new GeoDistanceResponse(postalCode1, postalCode2);
				
		return response;
	}
}
