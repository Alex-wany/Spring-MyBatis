package com.javasm.service;

import com.javasm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    //测试Service层的findAll方法
    @Test
    public void findAll() {
        List<User> all = userService.findAll();
        System.out.println(all);
    }


}