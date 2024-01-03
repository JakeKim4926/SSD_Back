package com.seongseobdang.controller;

import java.util.List;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/location")
@Api(tags = "지역 컨트롤러")
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
	@ApiOperation(value = "지역 조회", notes = "현재 등록되어 있는 지역들을 조회")
	public ResponseEntity<?> getAllLocations() {
		List<Location> list = service.getAllLocations();
		System.out.println("일로 오니 ?");
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
	}

}