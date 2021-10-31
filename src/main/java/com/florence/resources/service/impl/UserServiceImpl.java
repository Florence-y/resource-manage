package com.florence.resources.service.impl;

import com.florence.resources.po.User;
import com.florence.resources.mapper.UserMapper;
import com.florence.resources.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Florence
 * @since 2021-10-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
