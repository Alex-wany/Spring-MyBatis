package com.javasm.web;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.javasm.Util.R;
import com.javasm.entity.User;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;
import com.javasm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController//相当于@Controller+@ResponseBody 返回json数据 一般用这个 但是如果要返回页面就用@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    注入数据源 用来测试数据源是否配置成功 一般不会这么用 一般是在配置类中注入
    @Autowired
    private DataSource dataSource;//练习中用来验证数据源是否使用的是druid

    //测试pageHelper 分页插件
    @GetMapping("findByPage")
    public List<User> findAll() {
//        System.out.println(dataSource.getClass());

        PageHelper.startPage(1,4);//形参应该由前端传入 但是这里为了方便就写死了
        List<User> all = userService.findAll();
        PageInfo pageInfo = new PageInfo(all);
        System.out.println(pageInfo);
//        System.out.println(pageInfo.getList());
//        System.out.println(pageInfo.getPages());
//        System.out.println(pageInfo.getTotal());
        return all;
    }


    @GetMapping("findAll")
    public ResultVO findAll2() {

        List<User> all = userService.findAll();


        //封装返回数据
        /*ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("查询成功");
        resultVO.setData(all);
        return resultVO;*/

        //通过封装的方法
        return R.ok(all);
    }

    @GetMapping("findUsers")
    public List<User> findUsers(String name,String age1,String age2,String email) {
        return userService.findUsers(name,age1,age2,email);
    }

    //条件查询 方式 1 通过条件构造器 QueryWrapper
    @PostMapping("findUserByCondition")
    public List<User> findUserByCondition(@RequestBody User user) {
        return userService.findUserByCondition(user);
    }

    //条件查询 方式 2 通过注解
    @PostMapping("findUserByCondition2")
    public List<User> findUserByCondition2(@RequestBody User user) {
        return userService.findUserByCondition2(user);
    }

    //条件删除
    @DeleteMapping("deleteUserByCondition")
    public String deleteUserByCondition(String condition) {
        int row = userService.deleteUserByCondition(condition);
        System.out.println("删除了"+row+"条数据");
        return "删除成功";
    }

    //条件修改
    @GetMapping("updateUserByCondition")
    public String updateUserByCondition(String name,String email) {
        int row = userService.updateUserByCondition(name,email);
        System.out.println("修改了"+row+"条数据");
        return "修改成功";
    }

    //条件修改
    @GetMapping("updateUserByCondition2")
    public String updateUserByCondition2(String name) {
        int row = userService.updateUserByCondition2(name);
        System.out.println("修改了"+row+"条数据");
        return "修改成功";
    }

    @GetMapping("findUserById")
    public User findUserById(Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping("addUserById")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "添加成功";
    }

    @PutMapping("updateUserById")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "修改成功";
    }

    @DeleteMapping("deleteUserById")
    public String deleteUser(Integer id) {
        userService.deleteUser(id);
        return "删除成功";
    }




}
