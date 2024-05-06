package com.javasm.demo;

import com.javasm.entity.User;
import com.javasm.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

// 测试乐观锁插件的使用
// 1. 在实体类中添加 @Version 注解
// 2. 在数据库中添加 version 字段
// 3. 在配置类中添加乐观锁插件的拦截器
// 4. 在测试类中测试


@SpringBootTest // 该注解表示这是一个测试类
public class testDemo {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test01(){
        User user1 = userMapper.selectById(1);
        User user2 = userMapper.selectById(1);

        user1.setAge(20);



    }

}
