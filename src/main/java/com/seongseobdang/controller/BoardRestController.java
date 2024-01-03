package com.seongseobdang.controller;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seongseobdang.model.dto.Board;
import com.seongseobdang.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/board")
@Api(tags = "게시판 컨트롤러")
@CrossOrigin("*")
public class BoardRestController extends HttpServlet {

	@Autowired
	private BoardService boardService;

	@GetMapping("/{location_id}/{mountain_id}")
	@ApiOperation(value = "게시글 조회", notes = "일정 위치의 일정 산의 게시판 글 전부 조회")
	public ResponseEntity<?> list(@PathVariable int location_id, @PathVariable int mountain_id) {
		List<Board> list = boardService.getList(location_id, mountain_id);
		System.out.println("check 2");
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 2. 상세보기
	@GetMapping("/{location_id}/{mountain_id}/{board_id}")
	@ApiOperation(value = "게시글 상세보기", notes = "게시판의 글 상세보기")
	public ResponseEntity<Board> detail(@PathVariable int location_id, @PathVariable int mountain_id, @PathVariable int board_id) {
		System.out.println("are you here");
		Board board = boardService.getBoard(location_id, mountain_id, board_id);

		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	// 3. 등록
	@PostMapping("")
	@ApiOperation(value = "게시글 등록", notes = "해당 산에 대한 등산 후기를 등록")
	public ResponseEntity<Board> write(@RequestBody Board board) {
		boardService.writeBoard(board);
		
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/{location_id}/{mountain_id}/{board_id}")
	@ApiOperation(value = "게시글 삭제", notes = "특정 게시글 삭제")
	public ResponseEntity<Void> delete(@PathVariable int location_id, @PathVariable int mountain_id, @PathVariable int board_id) {

		boardService.removeBoard(location_id, mountain_id, board_id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 5. 수정
	@PutMapping("") // JSON 형태의 데이터로 넘어왔을 떄 처리하고 싶은데?
	@ApiOperation(value = "게시글 삭제", notes = "특정 게시글 수정")
	public ResponseEntity<Void> update(@RequestBody Board board) {
		boardService.modifyBoard(board);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
