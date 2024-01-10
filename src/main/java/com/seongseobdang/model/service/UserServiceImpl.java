package com.seongseobdang.model.service;

import java.util.List;

import com.seongseobdang.util.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seongseobdang.model.dao.UserDao;
import com.seongseobdang.model.dto.User;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    
    @Override
    public List<User> getUserList() {
        return userDao.selectAll();
    }

    
    //최영진 / 박소현 아주 훌륭 그자체
    @Override
    public int signup(User user) {
    	User tmp = userDao.selectOne(user.getId());
    	
    	// 아이디 중복 여부 확인
    	if(tmp != null)
    		return Output.ID_DUPLICATE.getNum();
    	
        return userDao.insertUser(user);
    }


    @Override
    public User login(String id, String pass) {
        //DB 해당 ID만 넘겨서 데이터를 가지고 오고 가지고온 User 데이터와 내가 현재 가지고 있는 user의 비밀번호를 확인하면
    	User tmp = userDao.selectOne(id);
        // tmp가 실제 User 정보 일수도 있고 / null 넘어왔다.
        if(tmp != null && tmp.getPw().equals(pass))
            return tmp;
        return null;
    }

}
