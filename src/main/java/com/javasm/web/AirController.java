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

    @Autowired
    private AirService airService;

    /*
    * 查询所有区域信息
    * */
    @GetMapping("/district/list")
    public ResultVO districtList(){
        return R.ok(airService.districtList());
    }

    /**
     * 分页&条件查询空气质量信息
     * Get http://localhost:8080/air/list
     * 请求参数
     *  page 页码 默认1
     *  limit 每页显示条数 默认5
     *  districtId = null 区域条件
      */
    @GetMapping("/air/list")
    public ResultVO airList(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "5") Integer limit,
                            @RequestParam(required = false) String districtId){
        //调用service层方法查询空气质量信息
        PageInfo pageInfo = airService.airListByDistractAndPage(page,limit,districtId);
        return R.ok(pageInfo,pageInfo.getTotal());
    }



}
