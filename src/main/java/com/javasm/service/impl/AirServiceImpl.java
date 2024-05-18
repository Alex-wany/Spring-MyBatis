package com.javasm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.dto.AirAddDto;
import com.javasm.entity.Air;
import com.javasm.entity.District;
import com.javasm.mapper.AirMapper;
import com.javasm.mapper.DistrictMapper;
import com.javasm.service.AirService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirServiceImpl implements AirService {

    @Autowired
    private AirMapper airMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> districtList() {
        List<District> all = districtMapper.findAll();
        return all;
    }

    /**
     * 分页&条件查询空气质量信息
     */
    @Override
    public PageInfo airListByDistractAndPage(Integer page, Integer limit, String districtId) {
//        第一步 分页
        PageHelper.startPage(page,limit);
//        第二步 条件查询
        List<Air> byDistractId = airMapper.findByDistractId(districtId);
//        第三步 封装 PageInfo
        PageInfo pageInfo = new PageInfo(byDistractId);
//        第四步 返回
        return pageInfo;
    }

    @Override
    @Transactional//添加事务 保证数据的一致性
    public void addAir(AirAddDto airAddDto) {
        //封装数据
        Air air = new Air();
        //使用spring提供的工具类 将airAddDto中的数据拷贝到air中
        BeanUtils.copyProperties(airAddDto,air);
       /* air.setDistrictId(airAddDto.getDistrictId());
        air.setMonitoringStation(airAddDto.getMonitoringStation());
        air.setMonitorTime(airAddDto.getMonitorTime());
        air.setPm25(airAddDto.getPm25());
        air.setPm10(airAddDto.getPm10());*/
        //调用mapper层方法添加数据
        int insert = airMapper.insert(air);
        //判断是否添加成功 如果返回值为0 说明添加失败
        if (insert == 0){
            System.out.println("添加失败");
            throw new RuntimeException("添加失败");
        }


    }

    @Override
    public void updateAir(Air air) {
        //调用mapper层方法修改数据
        int update = airMapper.update(air);
        //判断是否修改成功 如果返回值为0 说明修改失败
        if (update == 0){
            System.out.println("修改失败");
            throw new RuntimeException("修改失败");
        }
    }


}
