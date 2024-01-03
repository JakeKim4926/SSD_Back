package com.seongseobdang.model.dao;

import java.util.List;

import com.seongseobdang.model.dto.Location;

public interface LocationDao {
	List<Location> getAllLocations();

	Location getOneLocation();
}
