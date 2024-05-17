package com.javasm.mapper;


import com.javasm.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTest {

    @Autowired
    private DistrictMapper districtMapper;

    //测试DistrictMapper的findAll方法
    @Test
    public void findAll() {
        List<District> all = districtMapper.findAll();
        System.out.println(all);
    }

}