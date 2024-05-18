package com.javasm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Air {
// 实体类此处作用
// 1.与数据库映射
// 2.接收前端传递的参数 通过@DateTimeFormat来接收时间格式
// 3.返回给前端的数据 通过@JsonFormat来格式化时间
// 使得实体类承载了太多功能 可以考虑拆分
    private Integer id;
    @JsonIgnore//忽略字段
    private String districtId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//格式化时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收时间格式
    private Date monitorTime;
    private Integer pm10;
    private Integer pm25;
    private String monitoringStation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastModifyTime;
    //多表查询映射区域名称 一对一
    private String districtName;


}