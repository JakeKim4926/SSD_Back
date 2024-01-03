package com.seongseobdang.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seongseobdang.model.dao.LocationDao;
import com.seongseobdang.model.dto.Location;


@Service
public class LocationServiceImpl implements LocationService{
	// 의존성 주입
	private LocationDao dao;
	
	public LocationServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public LocationServiceImpl(LocationDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Location> getAllLocations() {
		return dao.getAllLocations();
	}

	@Override
	public Location getOneLocation() {
		return dao.getOneLocation();
	}

	
}
