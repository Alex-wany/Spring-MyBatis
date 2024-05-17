package com.javasm.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AirMapperTest {

    @Autowired
    private AirMapper airMapper;

    //测试根据区域id查询空气质量信息
    @Test
    public void findByDistractId() {
        System.out.println(airMapper.findByDistractId("1"));
    }


}