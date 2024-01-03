package com.seongseobdang.model.dao;

import java.util.List;

import com.seongseobdang.model.dto.Mountain;

// DB 너낌 나게 작성해라아 by 띵쌤
public interface MountainDao {

	List<Mountain> getMountains(int location_id);
	
	Mountain getOneMountain(int location_id, int mountain_id);
}
