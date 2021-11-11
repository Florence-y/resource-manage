package com.florence.resources.controller;


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
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    ResponseStat<User> update(@RequestBody User user, HttpServletRequest request) {
        if (!Objects.isNull(user)) {
            Object userId = SessionUtil.getSessionAttribute(request, "userId");
            if (Objects.isNull(userId)){
                return ResponseStatHelper.error("未登录");
            }
            user.setId((Long) userId);
            log.info(user.toString());
            boolean save = userService.updateById(user);
            return save ? ResponseStatHelper.success("修改成功", user)
                    : ResponseStatHelper.error("个人信息修改失败（信息填写错误）");
        }
        return ResponseStatHelper.error("个人信息修改错误（未知错误）");
    }


}
