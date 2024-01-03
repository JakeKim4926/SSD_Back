package com.seongseobdang.model.service;

import java.util.List;

import com.seongseobdang.model.dto.Mountain;

public interface MountainService {
	// 산 갖고오자
	List<Mountain> getMountains(int location_id);
	
	// 산 하나만 갖고오자
	Mountain getOneMountain(int location_id, int mountain_id);
}
