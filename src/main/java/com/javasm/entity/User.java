package com.javasm.entity;//包名

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;//序列化接口,实现序列化接口的类可以被序列化和反序列化

//mybatis-plus默认使用驼峰命名规则 但是数据库字段是】可能下划线命名规则 所以需要使用注解来指定数据库字段名
//使用@TableId注解来指定主键 以及主键生成策略
//使用@TableName注解来指定当前实体类对应的表名
//使用@Version注解来指定乐观锁版本号
//使用@SqlCondition注解来指定字段查询策略
//使用@TableField注解来指定字段名 以及字段查询策略
//使用@TableId注解来指定主键 以及主键生成策略
@TableName("user") //指定当前实体类对应的表名
public class User implements Serializable {
    @TableId(value = "id",type = IdType.AUTO) //主键使用TableId 指定主键 以及主键生成策略为自增
    private long id;
    @TableField(value = "name",condition = SqlCondition.LIKE) //非主键字段使用TableField 指定字段名 以及字段查询策略
    private String username;
    private Integer age;
    private String email;
//    @Version
//    private Integer version;//乐观锁版本号


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
//                ", version=" + version +
                '}';
    }

//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
