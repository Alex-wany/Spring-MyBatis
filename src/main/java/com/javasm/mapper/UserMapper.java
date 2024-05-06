package com.javasm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javasm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
// 代表这是一个 MyBatis 的 Mapper 将接口的代理类交给 Spring 管理（放到容器中）
//如果以后要大量写 mapper 每个类上都要加@mapper 不如直接在配置类上写@MapperScan
//mybatis-plus 最核心内容就是继承BaseMapper 里面封装了很多基本的CRUD方法
public interface UserMapper extends BaseMapper<User> {

    //@Select("select * from user")//该方法不好用，还是建议使用xml配置文件
    List<User> findAll();

}
