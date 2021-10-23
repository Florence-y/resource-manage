package com.florence.resources.services;


import com.florence.resources.po.User;

/**
 * @author Florence
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int save(User user);
}
