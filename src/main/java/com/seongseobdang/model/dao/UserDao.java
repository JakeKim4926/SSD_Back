package com.seongseobdang.model.dao;
import java.util.List;

import com.seongseobdang.model.dto.User;

public interface UserDao {
	List<User> selectAll();

	int insertUser(User user);
	
	User selectOne(String id);
}