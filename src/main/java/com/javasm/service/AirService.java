package com.javasm.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface AirService {

    /**
     * 分页&条件查询空气质量信息
     * @param page 页码 默认1
     * @param limit 每页显示条数 默认5
     * @param districtId 区域条件
     */
    PageInfo airListByDistractAndPage(Integer page, Integer limit, String districtId);


}
