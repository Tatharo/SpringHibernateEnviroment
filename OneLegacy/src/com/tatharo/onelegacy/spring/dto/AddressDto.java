package com.tatharo.onelegacy.spring.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {
	@NotNull
	private final String country;
	private final String province;
	private final String city;
	private final String street;
	private final String streetNumber;
	private final String zipCode;
	@JsonCreator
	public AddressDto(@JsonProperty("country")String country, @JsonProperty("province")String province, @JsonProperty("city")String city,
			@JsonProperty("street")String street,@JsonProperty("streetNumber") String streetNumber,@JsonProperty("zipCode") String zipCode) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	

}
