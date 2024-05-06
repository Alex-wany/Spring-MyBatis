package com.javasm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javasm.entity.User;
import com.javasm.mapper.UserMapper;
import com.javasm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);//查询所有
    }
//    此处是用mybatis-plus的分页插件 但是这个插件不支持前端传入分页参数 所以不太好用 使用方法是在service层写死分页参数 然后返回page对象 通过page对象获取分页信息
    @Override
    public List<User> findAll2() {
        Page page = new Page(1,3);
        userMapper.selectPage(page,null);
        System.out.println(page.getTotal());//总条数
        System.out.println(page.getPages());//总页数
        System.out.println(page.getSize());//每页显示条数
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//查询的数据
        return page.getRecords();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    //条件查询 方式 1 通过条件构造器 QueryWrapper
    @Override
    public List<User> findUserByCondition(User user) {
        //条件构造器 创建查询条件对象
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //设置查询条件 默认使用 and 连接 也可以使用 or 连接
        //参数1：数据库字段名 参数2：字段值
        userQueryWrapper.like("name",user.getName()).or().like("email",user.getEmail());
        //设置排序条件
        userQueryWrapper.orderByDesc("id");
        //执行查询
        return userMapper.selectList(userQueryWrapper);
    }

    //条件查询 方式 2 lambda表达式
    @Override
    public List<User> findUserByCondition2(User user) {
        //创建查询条件对象
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        //或者 LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        //设置查询条件
        lambda.like(User::getName,user.getName()).or().like(User::getEmail,user.getEmail());
        //设置排序条件
        lambda.orderByDesc(User::getId);

        //执行查询
        return userMapper.selectList(lambda);
    }

    @Override
    public List<User> findUsers(String search1, String search2, String search3, String search4) {
        //创建查询条件对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        wrapper.like(User::getName,search1)
                .or().between(User::getAge,search2,search3)
                .or().eq(User::getEmail,search4);
        //执行查询
        return userMapper.selectList(wrapper);

    }

    public List<User> findUsers2(String search1, String search2, String search3) {
        //创建查询条件对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        wrapper.like(User::getName,search1)
                .or().like(User::getAge,search3)
                .or().like(User::getEmail,search2);
        //执行查询
        return userMapper.selectList(wrapper);

    }

    //删除数据 根据name 去删除
    @Override
    public int deleteUserByCondition(String condition) {
        //创建查询条件对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //设置查询条件 参数一必须是表中的列名, 参数二是查询的内容
        wrapper.like(User::getName,condition);
        //执行删除
        int deleterows = userMapper.delete(wrapper);
        return deleterows;
    }

    //更新数据 根据name 去改变email
    @Override
    public int updateUserByCondition(String name,String email) {
        //创建查询条件对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        //参数一必须是表中的列名, 参数二是查询的内容
        wrapper.eq(User::getName,user.getName());

        //执行更新 参数一是更新的内容 参数二是查询条件
        int updaterows = userMapper.update(user,wrapper);
        System.out.println("更新了"+updaterows+"条数据");
        return updaterows;
    }

    @Override
    public int updateUserByCondition2(String name) {
        //创建查询条件对象
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        //设置查询条件
        wrapper.eq(User::getName,name);
        //设置更新内容 可以不传对象 直接传列名和值 用来精确更新 只在 updateWrapper的set方法中使用
        wrapper.set(User::getEmail, "123456789@189.com");
        //执行更新 参数一是更新的内容 参数二是查询条件
        int rows = userMapper.update(null, wrapper);

        System.out.println("更新了"+rows+"条数据");
        return rows;
    }


}
