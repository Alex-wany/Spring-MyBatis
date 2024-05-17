package com.javasm.mapper;


import com.github.pagehelper.PageInfo;
import com.javasm.entity.Air;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirMapper {


    //分页&条件查询空气质量信息
    List<Air> findByDistractId(String districtId);



}
