package com.geodistance.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geodistance.entities.PostalCode;
import com.geodistance.util.GeoDistanceUtil;

public class GeoDistanceResponse {
	@JsonIgnoreProperties("id")
	private PostalCode postalCode1;
	@JsonIgnoreProperties("id")
	private PostalCode postalCode2;
	private double distance;
	private final String UNIT = "km";

	public GeoDistanceResponse(PostalCode postalCode1, PostalCode postalCode2) {
		this.postalCode1 = postalCode1;
		this.postalCode2 = postalCode2;
		this.distance = GeoDistanceUtil.calculateDistance(postalCode1.getLatitude(), postalCode1.getLongitude(),
				postalCode2.getLatitude(), postalCode2.getLongitude());
	}

	public PostalCode getPostalCode1() {
		return postalCode1;
	}

	public PostalCode getPostalCode2() {
		return postalCode2;
	}

	public double getDistance() {
		return distance;
	}

	public String getUnit() {
		return UNIT;
	}

	@Override
	public String toString() {
		return "GeoDistanceResponse [postalCode1=" + postalCode1 + ", postalCode2=" + postalCode2 + ", distance="
				+ distance + ", UNIT=" + UNIT + "]";
	}

}
