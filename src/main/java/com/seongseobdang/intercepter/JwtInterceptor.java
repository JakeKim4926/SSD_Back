package com.seongseobdang.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.seongseobdang.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	private static final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtutil;
	
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		//request가 controller에 가기전에 발동
//		String token = request.getHeader(HEADER_AUTH);
//		//Header에 있는 "access-token" 확인
//		if(token !=null) {
//			System.out.println("토큰 검사 했음");
//			jwtutil.valid(token);
//			return true;
//		}//있으면 유효성 검사 후 통과하는지 확인
//		
//		throw new Exception("유효하지 않은 접근");
//		
//	}
//	
	
}
