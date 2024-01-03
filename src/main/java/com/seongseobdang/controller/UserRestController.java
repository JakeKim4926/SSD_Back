package com.seongseobdang.controller; 

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongseobdang.model.dto.User;
import com.seongseobdang.model.service.UserService;
import com.seongseobdang.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/user")
@Api(tags = "유저 컨트롤러")
//@CrossOrigin("*")
public class UserRestController {

	// UserService 라고 하는 친구를 주입
	@Autowired
	private UserService userService;
	
	//토큰 생성을 위해 주입
	@Autowired
	private JwtUtil jwtUtil;

	// 전체 유저 가져와
	@GetMapping("/users")
	@ApiOperation(value = "유저 조회", notes = "유저들 불러와")
	public List<User> userList() {
		return userService.getUserList();
	}

	@PostMapping("/signup")
	@ApiOperation(value = "회원 가입", notes = "회원 가입")
	public ResponseEntity<?> signup(@RequestBody User user) {
		int result = userService.signup(user);

		if (result == 1) {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		} else if (result == 2) {
			return new ResponseEntity<Integer>(2, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// ID, PW가 맞는 지 확인만 해서
	// 프론트로 넘겨주겠다.
	@PostMapping("/login")
	@ApiResponse(code = 200, message = "성공")
	@ApiOperation(value = "로그인", notes = "ID/PW 입력")
	public ResponseEntity<Map<String, Object>> login(String id, String pass) {
		Map<String, Object> result = new HashMap<String, Object>();
		// User 서비스 -> DAO DB 실제 유저인지 아닌지 확인
		User tmp = userService.login(id, pass);
		HttpStatus status = null;
		try {
			if (tmp!= null) {
				result.put("access-token", jwtUtil.createToken("id", tmp.getId()));
				result.put("message", tmp.getName());
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", "fail");
				status = HttpStatus.NO_CONTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("message", "error");
		}
		System.out.println(result);
		return new ResponseEntity<Map<String,Object>>(result, status);
	}

	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃", notes = "로그아웃")
	public ResponseEntity<String> logout(@ApiIgnore HttpSession session) {

		session.invalidate();
		return new ResponseEntity<String>("Logout", HttpStatus.OK);
	}

}