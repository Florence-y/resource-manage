package com.florence.resources.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.florence.resources.common.reply.ResponseStat;
import com.florence.resources.common.reply.ResponseStatHelper;
import com.florence.resources.po.User;
import com.florence.resources.service.IUserService;
import com.florence.resources.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Florence
 * @since 2021-10-31
 */
@RestController
@RequestMapping
@Slf4j
public class UserController {


    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
    ResponseStat<User> login(@RequestBody User user, HttpServletRequest request) {
        User one = userService.getOne(new QueryWrapper<>(user));
        if (one != null) {
            log.info("学号：{}，密码：{},登录成功", user.getNumber(), user.getPassword());
            SessionUtil.setSessionAttribute(request, "number", one.getNumber());
            SessionUtil.setSessionAttribute(request, "userId", one.getId());
            return ResponseStatHelper.success("登录成功", one);
        }
        log.info("学号：{}，密码：{},登录失败", user.getNumber(), user.getPassword());
        return ResponseStatHelper.error("登录失败");
    }

    @RequestMapping(value = "/islogin", produces = "application/json", method = RequestMethod.GET)
    ResponseStat<User> isLogin(HttpServletRequest request) {
        Long number = (Long) SessionUtil.getSessionAttribute(request, "userId");
        if (!Objects.isNull(number)) {
            User userInf = userService.getById(number);
            return ResponseStatHelper.success("已登录", userInf);
        }
        return ResponseStatHelper.error("未登录");
    }

}
