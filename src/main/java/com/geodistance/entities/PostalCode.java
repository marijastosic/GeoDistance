package com.geodistance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Marija
 *
 */
@Entity
@Table(name = "postcodelatlng")
public class PostalCode implements Serializable {

	private static final long serialVersionUID = -1679461334940644477L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	public PostalCode() {

	}

	public PostalCode(int id, String postcode, String latitude, String longitude) {
		this.id = id;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "PostalCode [id=" + id + ", postcode=" + postcode + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

}
