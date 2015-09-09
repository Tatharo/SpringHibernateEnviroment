package com.tatharo.onelegacy.spring.dto;

public final class PersonLoginRequestDto {
	public PersonLoginRequestDto(int id, String location, String name) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	private int id;
	private String location;
	private String name;

}