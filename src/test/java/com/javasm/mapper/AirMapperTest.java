package com.javasm.mapper;


import com.javasm.entity.Air;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Test
    @Transactional//添加事务 保证数据的一致性 事务回滚 保证数据不会污染数据库
    public void insert() {
        Air air = new Air();
        air.setDistrictId("1");
        air.setMonitoringStation("100监测站");
        air.setMonitorTime(new Date());
        air.setPm25(100);
        air.setPm10(200);
        air.setLastModifyTime(new Date());
        int insert = airMapper.insert(air);
        Assert.assertEquals(1,insert);//断言 期望值为1 实际值为insert 如果不相等则抛出异常
    }


}