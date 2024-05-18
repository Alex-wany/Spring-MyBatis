package com.javasm.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

//封装返回结果 code  msg  data total 用于前端接收数据
@Data//lombok自动生成get set方法 toString方法 无参构造方法 有参构造方法 equals方法 hashCode方法 重写的方法
public class ResultVO {
    private Integer code;// 返回状态码
    private String msg; // 返回信息
    @JsonInclude(JsonInclude.Include.NON_NULL)//如果data为null则不返回
    private Object data;// 返回数据
    @JsonInclude(JsonInclude.Include.NON_NULL)//如果total为null则不返回
    private long total;// 返回数据总数


}
