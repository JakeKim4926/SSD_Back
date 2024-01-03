package com.seongseobdang.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seongseobdang.model.dao.MountainDao;
import com.seongseobdang.model.dto.Mountain;


@Service
public class MountainServiceImpl implements MountainService{
	// 의존성 주입
	private MountainDao dao;
	
	public MountainServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public MountainServiceImpl(MountainDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Mountain> getMountains(int location_id) {
		// TODO Auto-generated method stub
		return dao.getMountains(location_id);
	}

	@Override
	public Mountain getOneMountain(int location_id, int mountain_id) {
		// TODO Auto-generated method stub
		return dao.getOneMountain(location_id, mountain_id);
	}
}
