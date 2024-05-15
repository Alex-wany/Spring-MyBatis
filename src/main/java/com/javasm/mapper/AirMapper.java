package com.javasm.mapper;


import com.javasm.entity.Air;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class AirMapper {

    // 根据区域id查询空气质量信息

    public List<Air> findByDistractId(@Param("districtId") String districtId) {

        return null;
    }
}
