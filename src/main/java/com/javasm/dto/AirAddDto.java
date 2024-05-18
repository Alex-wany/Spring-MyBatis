package com.javasm.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AirAddDto {

    @NotNull(message = "区域id不能为空")//非空校验
    private String districtId;
    @NotBlank(message = "监测站不能为空")//非空校验 即能校验null 也能校验空字符串
    private String monitoringStation;
    @NotNull(message = "监测时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date monitorTime;
    @NotNull(message = "pm2.5不能为空")
    private Integer pm25;
    @NotNull(message = "pm10不能为空")
    private Integer pm10;


//     * 请求参数  正常为了解耦 会单独封装一个dto对象去接收参数 也可以使用@RequestParam注解接收参数 但是参数较多时不推荐 使用dto对象接收 代码更加清晰
//     * districtId 区域id 必填
//     * monitoringStation 监测站 必填
//     * monitorTime 监测时间 必填
//     * pm2_5 pm2.5 必填
//     * pm10 pm10 必填



}
