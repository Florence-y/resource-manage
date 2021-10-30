package com.florence.resources.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.florence.resources.mapper.UserMapper;
import com.florence.resources.po.User;
import com.florence.resources.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author Florence
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {



}
