package com.javasm.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

//封装返回结果 code  msg  data 三个属性
@Data//lombok自动生成get set方法 toString方法 无参构造方法 有参构造方法 equals方法 hashCode方法 重写的方法
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;
    @JsonInclude(JsonInclude.Include.NON_NULL)//如果data为null则不返回
    private long total;


}
