package com.cobra.freemarker.service.impl;

import com.cobra.freemarker.service.UserService;
import com.cobra.freemarker.vo.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Baron
 * @Description: 用户服务实现
 * @Date: Created in 2019/3/23 23:42
 */
@Service
public class UserServiceImpl implements UserService {

    private ConcurrentMap<Integer,User> userMap = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 根据userId查找User
     *
     * @param userId
     * @return
     */
    @Override
    public User findById(Integer userId) {
        return userMap.get(userId);
    }

    /**
     * 添加新用户
     *
     * @param user
     */
    @Override
    public void add(User user) {
        user.setUserId(idGenerator.incrementAndGet());
        userMap.put(user.getUserId(), user);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public Collection<User> findAllUsers() {
        return userMap.values();
    }
}
