package com.javasm.service;

import com.github.pagehelper.PageInfo;
import com.javasm.dto.AirAddDto;
import com.javasm.entity.Air;
import com.javasm.entity.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirService {

    /**
     * 查询所有区域信息
     */
    List<District> districtList();


    /**
     * 分页&条件查询空气质量信息
     * @param page 页码 默认1
     * @param limit 每页显示条数 默认5
     * @param districtId 区域条件
     */
    PageInfo airListByDistractAndPage(Integer page, Integer limit, String districtId);


    void addAir(AirAddDto airAddDto);

    void updateAir(Air air);
}
