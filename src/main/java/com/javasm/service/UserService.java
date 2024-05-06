package com.javasm.service;

import com.javasm.entity.User;
import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findAll2();
    User findUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> findUserByCondition(User user);

    List<User> findUserByCondition2(User user);


    List<User> findUsers(String search1, String search2, String search3, String search4);

    int deleteUserByCondition(String condition);

    int updateUserByCondition(String name,String email);


    int updateUserByCondition2(String name);
}
