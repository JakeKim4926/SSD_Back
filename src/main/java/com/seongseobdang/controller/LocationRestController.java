package com.seongseobdang.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongseobdang.model.dto.Location;
import com.seongseobdang.model.dto.Mountain;
import com.seongseobdang.model.service.LocationService;

@RestController
@RequestMapping("/api/location")
@Tag(name = "지역 컨트롤러")
@CrossOrigin("*")
public class LocationRestController {

	private LocationService service;

	@Autowired
	public LocationRestController(LocationService service) {
		super();
		this.service = service;
	}

	// 1. 목록
	@GetMapping("/")
	@Operation(summary = "지역 조회", description = "현재 등록되어 있는 지역들을 조회")
	public ResponseEntity<?> getAllLocations() {
		List<Location> list = service.getAllLocations();
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
	}

}