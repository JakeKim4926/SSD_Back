package com.seongseobdang.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seongseobdang.model.dao.BoardDao;
import com.seongseobdang.model.dto.Board;


@Service
public class BoardServiceImpl implements BoardService{
	
	//의존성 주입
	@Autowired
	private BoardDao dao;

	private BoardServiceImpl() {
		
	}
	
	
	@Override
	public List<Board> getList(int location_id, int mountain_id) {
		return dao.selectAll(location_id, mountain_id);
	}

	@Override
	public void writeBoard(Board board) {
		dao.insertBoard(board);
	}

	@Override
	public Board getBoard(int location_id, int mountain_id, int board_id) {
		dao.updateViewCnt(location_id, mountain_id, board_id);
		return dao.selectOne(location_id, mountain_id, board_id);
	}

	@Override
	public void modifyBoard(Board board) {
		dao.updateBoard(board);
		
	}

	@Override
	public void removeBoard(int location_id, int mountain_id, int board_id) {
		dao.deleteBoard(location_id, mountain_id, board_id);
	}

}
