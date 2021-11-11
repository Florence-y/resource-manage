package com.florence.resources.service_test;


import com.florence.resources.ResourcesApplication;
import com.florence.resources.po.User;
import com.florence.resources.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ResourcesApplication.class)
public class UserServiceTest {
    @Autowired
    IUserService userService;

    @Test
    public void insertUser(){
        User user = new User()
                .setName("吴彦臻")
                .setNumber("191541227")
                .setDepartment("互联网金融与信息工程学院")
                .setMajor("计算机科学与技术")
                .setPassword("qq123456")
                .setRole(1)
                .setAvatar("1.jpg");
        boolean save = userService.save(user);
//        User user = userService.getById(1);
//        userService.removeById(1);
        System.out.println(user);
    }
}
