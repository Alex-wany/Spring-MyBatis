package com.javasm.service;


import com.github.pagehelper.PageInfo;
import com.javasm.dto.AirAddDto;
import com.javasm.entity.Air;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    //测试Service层的addAir方法
    @Test
    public void addAir() {
        AirAddDto airAddDto = new AirAddDto();
        airAddDto.setDistrictId("1");
        airAddDto.setMonitoringStation("100监测站");
        airAddDto.setMonitorTime(new Date());
        airAddDto.setPm25(100);
        airAddDto.setPm10(200);
        airService.addAir(airAddDto);
    }

    //测试Service层的updateAir方法
    @Test
    public void updateAir() {
        Air air = new Air();
        air.setId(7);
        air.setDistrictId("78");
        air.setMonitoringStation("888站点");
        air.setMonitorTime(new Date());
        air.setPm25(100);
        air.setPm10(200);
        air.setLastModifyTime(new Date());
        airService.updateAir(air);
    }

    //测试Service层的deleteAir方法
    @Test
    public void deleteAir() {
        airService.deleteAir(7);

    }


}