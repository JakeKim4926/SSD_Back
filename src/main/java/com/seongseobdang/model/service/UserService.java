package com.seongseobdang.model.service;

import java.util.List;

import com.seongseobdang.model.dto.User;

public interface UserService {

//    public abstract List<User> getUserList(); //아래와 동일
    List<User> getUserList();

    int signup(User user);

    User login(String id, String pass);
    
}