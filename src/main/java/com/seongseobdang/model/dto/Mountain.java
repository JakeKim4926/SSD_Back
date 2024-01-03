package com.seongseobdang.model.dto;

public class Mountain {
	private int location_id;
	private int mountain_id;
	private double latitude;
	private double longtitude;
	private int time;
	private String mountain;
	
	public Mountain() {
		// TODO Auto-generated constructor stub
	}
	
	public Mountain(int location_id, int mountain_id, double latitude, double longtitude, int time, String mountain) {
		super();
		this.location_id = location_id;
		this.mountain_id = mountain_id;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.time = time;
		this.mountain = mountain;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public int getMountain_id() {
		return mountain_id;
	}

	public void setMountain_id(int mountain_id) {
		this.mountain_id = mountain_id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getMountain() {
		return mountain;
	}

	public void setMountain(String mountain) {
		this.mountain = mountain;
	}

	@Override
	public String toString() {
		return "Mountain [location_id=" + location_id + ", mountain_id=" + mountain_id + ", latitude=" + latitude
				+ ", longtitude=" + longtitude + ", time=" + time + ", mountain=" + mountain + "]";
	}
	
}
