package com.javasm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.entity.Air;
import com.javasm.mapper.AirMapper;
import com.javasm.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class AirServiceImpl implements AirService {

    @Autowired
    private AirMapper airMapper;

    /**
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
}
