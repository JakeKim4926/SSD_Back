package com.seongseobdang.model.dto;

public class Location {
	int location_id;
	String city;
	String area;
	
	public Location(int location_id, String city, String area) {
		super();
		this.location_id = location_id;
		this.city = city;
		this.area = area;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Location [location_id=" + location_id + ", city=" + city + ", area=" + area + "]";
	}
}
