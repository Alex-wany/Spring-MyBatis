package com.javasm.service;


import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirServiceTest {

    @Autowired
    private AirService airService;

    //测试Service层的districtList方法
    @Test
    public void districtList() {
        System.out.println(airService.districtList());
    }

    //测试Service层的airListByDistractAndPage方法
    @Test
    public void airListByDistractAndPage() {
        PageInfo pageInfo = airService.airListByDistractAndPage(1, 5, null);
        pageInfo.getList().forEach(System.out::println);
        System.out.println("一共有" + pageInfo.getTotal() + "条数据");

    }


}