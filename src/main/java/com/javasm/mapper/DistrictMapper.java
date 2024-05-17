package com.javasm.mapper;

import com.javasm.entity.District;

import java.util.List;

public interface DistrictMapper {
    // 查询所有区域信息
    List<District> findAll();
}
