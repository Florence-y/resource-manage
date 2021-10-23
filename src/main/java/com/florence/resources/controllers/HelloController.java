package com.florence.resources.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.florence.resources.dto.UserDto;
import com.florence.resources.po.User;
import com.florence.resources.services.UserService;
import com.florence.resources.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Florence
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(UserDto userDto) {
        try {
            userService.save(convertDto(userDto));
            return JsonUtil.objToJson(userDto);
        } catch (JsonProcessingException e) {
            log.error("Json转化失败");
        }
        return "500";
    }


    private User convertDto(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}
