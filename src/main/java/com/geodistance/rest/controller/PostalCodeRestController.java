package com.geodistance.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.geodistance.entities.PostalCode;
import com.geodistance.service.PostalCodeService;

@RestController
@RequestMapping("/postalcodes")
public class PostalCodeRestController {
	
	@Autowired
	private PostalCodeService postalCodeService;
	
	@GetMapping
	public List<PostalCode> getAllPostalCodes(){
		return postalCodeService.getAllPostalCodes();		
	}

	@RequestMapping(params = "postcode", method = RequestMethod.GET)
	public PostalCode getPostalCodeByPostcode(@RequestParam(name = "postcode") String postcode) {
		return postalCodeService.getByPostcode(postcode);
	}
	
	@RequestMapping(params = "id", method = RequestMethod.GET)
	public PostalCode getPostalCodeById(@RequestParam("id") Integer id) {
		return postalCodeService.getById(id);
	}
	
	@PostMapping
	public PostalCode savePostalCode(@RequestBody PostalCode postalCode) {
		return postalCodeService.save(postalCode);
	}
	
	@PutMapping
	public PostalCode updatePostalCode(@RequestBody PostalCode postalCode) {
		return postalCodeService.save(postalCode);
	}
	
	@DeleteMapping("/{id}")
	public void deletePostalCode(@PathVariable Integer id) {
		postalCodeService.delete(id);
		
	}

}
