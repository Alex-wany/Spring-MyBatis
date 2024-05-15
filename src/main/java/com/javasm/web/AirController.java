package com.javasm.web;

import com.github.pagehelper.PageInfo;
import com.javasm.Util.R;
import com.javasm.service.AirService;
import com.javasm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirController {
    /**
     * 分页&条件查询空气质量信息
     * Get http://localhost:8080/air/list
     * 请求参数
     *  page 页码 默认1
     *  limit 每页显示条数 默认5
     *  districtId = null 区域条件
      */

    @Autowired
    private AirService airService;

    @GetMapping("/air/list")
    public ResultVO airList(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer limit,
                            @RequestParam(required = false) String districtId){
        //调用service层方法查询空气质量信息
        PageInfo pageInfo = airService.airListByDistractAndPage(page,limit,districtId);
        return R.ok(pageInfo);
    }



}
