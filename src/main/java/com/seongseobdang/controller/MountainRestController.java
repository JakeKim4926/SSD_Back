package com.seongseobdang.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongseobdang.model.dto.Mountain;
import com.seongseobdang.model.service.MountainService;

@RestController
@RequestMapping("/api/mountain")
@Tag(name = "산 컨트롤러")
@CrossOrigin("*")
public class MountainRestController {

	private MountainService service;

	@Autowired
	public MountainRestController(MountainService service) {
		super();
		this.service = service;
	}

	// 1. 목록
	@GetMapping("/{location_id}")
	@Operation(summary = "산 조회", description = "일정 지역에 등록되어 있는 모든 산 출력")
	public ResponseEntity<?> getMountains(@PathVariable int location_id) {
		List<Mountain> list = service.getMountains(location_id);

		if (list == null || list.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Mountain>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{location_id}/{mountain_id}")
	@Operation(summary = "산 하나 조회", description = "id와 매칭 되는 산 조회")
	public ResponseEntity<?> getMountains(@PathVariable int location_id, @PathVariable int mountain_id) {
		Mountain mountain = service.getOneMountain(location_id, mountain_id);

		if (mountain == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Mountain>(mountain, HttpStatus.OK);
	}

}