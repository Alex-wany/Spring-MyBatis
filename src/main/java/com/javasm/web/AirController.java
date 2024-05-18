package com.javasm.web;

import com.github.pagehelper.PageInfo;
import com.javasm.Util.R;
import com.javasm.dto.AirAddDto;
import com.javasm.entity.Air;
import com.javasm.service.AirService;
import com.javasm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    /**
     * 添加空气质量信息
     * Post http://localhost:8080/air/add
     * 请求参数  正常为了解耦 会单独封装一个dto对象去接收参数 也可以使用@RequestParam注解接收参数 但是参数较多时不推荐 使用dto对象接收 代码更加清晰
     * districtId 区域id 必填
     * monitoringStation 监测站 必填
     * monitorTime 监测时间 必填
     * pm25 pm2.5 必填
     * pm10 pm10 必填
     * 业务流程
     * 1.接收参数
     * 2.参数校验
     * 3.调用service层方法添加空气质量信息
     * 4.返回结果
    * */
    @PostMapping("/air/add")
    public ResultVO addAir(@Valid AirAddDto airAddDto, BindingResult bindingResult){
        //参数校验
        if(bindingResult.hasErrors()){
            //获取校验失败的信息并返回
            return R.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        //调用service层方法添加空气质量信息
        airService.addAir(airAddDto);
        //返回结果
        return R.ok();
    }
    /*@PostMapping("/air/add")
    public ResultVO addAir(@RequestParam String districtId,
                           @RequestParam String monitoringStation,
                           @RequestParam String monitorTime,
                           @RequestParam Integer pm25,
                           @RequestParam Integer pm10){
        //调用service层方法添加空气质量信息
        airService.addAir(districtId,monitoringStation,monitorTime,pm2_5,pm10);
        return R.ok();
    }*/

    /**
     * 修改空气质量信息
     * Post http://localhost:8080/air/update
     * 请求参数  正常为了解耦 会单独封装一个dto对象去接收参数 也可以使用@RequestParam注解接收参数 但是参数较多时不推荐 使用dto对象接收 代码更加清晰
     * id 主键 必填
     * districtId 区域id 非必填
     * monitoringStation 监测站 非必填
     * monitorTime 监测时间 非必填
     * pm25 pm2.5 非必填
     * pm10 pm10 非必填
     * 业务流程
     * 1.接收参数
     * 2.参数校验
     * 3.调用service层方法添加空气质量信息
     * 4.返回结果
    * */
    @PostMapping("/air/update")
    public ResultVO updateAir(Air air){
        //参数校验
        if(air.getId() == null){
            return R.error(400,"id不能为空");
        }
        //调用service层方法添加空气质量信息
        airService.updateAir(air);
        //返回结果
        return R.ok();
    }

    /**
     * 删除空气质量信息
     * Get http://localhost:8080/air/delete
     * 请求参数
     * id 主键 必填
     * 业务流程
     * 1.接收参数
     * 2.参数校验
     * 3.调用service层方法删除空气质量信息
     * 4.返回结果
     * */
//    @GetMapping("/air/delete")
//    public ResultVO deleteAir(Integer id){
//        //参数校验
//        if(id == null){
//            return R.error(400,"id不能为空");
//        }
//        //调用service层方法删除空气质量信息
//        airService.deleteAir(id);
//        //返回结果
//        return R.ok();
//    }


}
