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
                .setDepartment("学生组")
                .setPassword("qq123456")
                .setRole(3);
        boolean save = userService.save(user);
//        User user = userService.getById(1);
//        userService.removeById(1);
        System.out.println(user);
    }
}
