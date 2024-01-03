package com.seongseobdang.model.service;

import java.util.List;

import com.seongseobdang.model.dto.Location;

public interface LocationService {
	List<Location> getAllLocations();
	
	Location getOneLocation();
}
