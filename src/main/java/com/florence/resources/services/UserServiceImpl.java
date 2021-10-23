package com.florence.resources.services;

import com.florence.resources.mappers.UserMapper;
import com.florence.resources.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Florence
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }
}
