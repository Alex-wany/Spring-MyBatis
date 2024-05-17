package com.javasm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class Air {

    private Integer id;
    @JsonIgnore//忽略字段
    private String districtId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//格式化时间
    private Date monitorTime;
    private Integer pm10;
    private Integer pm25;
    private String monitoringStation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastModifyTime;
    //多表查询映射区域名称 一对一
    private String districtName;


}