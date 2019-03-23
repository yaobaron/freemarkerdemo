package com.cobra.freemarker.service;

import com.cobra.freemarker.vo.User;

import java.util.Collection;

/**
 * @Author: Baron
 * @Description: 用户服务接口
 * @Date: Created in 2019/3/23 23:26
 */
public interface UserService {

    /**
     * 根据userId查找User
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 添加新用户
     * @param user
     */
    void add(User user);

    /**
     * 查询所有用户
     * @return
     */
    Collection<User> findAllUsers();

}
