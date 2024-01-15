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

    
    @Override
    public int signup(User user) {
    	User tmp = userDao.selectOne(user.getId());
    	
    	if(tmp != null)
    		return Output.ID_DUPLICATE.getNum();
    	
        return userDao.insertUser(user);
    }


    @Override
    public User login(String id, String pass) {
    	User tmp = userDao.selectOne(id);
        if(tmp != null && tmp.getPw().equals(pass))
            return tmp;
        return null;
    }

}
