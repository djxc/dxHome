package com.djxc.study.web.service;



import com.djxc.study.demo.entity.User;

import java.util.List;

/**
 * 用户的服务接口
 */
public interface IUserService {

    List<User> selectUsers();
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 通过用户名称查询用户信息
     * @param name
     * @return
     */
    User selectByName(String name);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    boolean deleteUser(int id);

    /**
     * 根据用户名称删除用户
     * @param name
     * @return
     */
    boolean deleteUser(String name);

}
