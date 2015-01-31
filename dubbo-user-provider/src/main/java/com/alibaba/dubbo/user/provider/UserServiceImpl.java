package com.alibaba.dubbo.user.provider;

import com.alibaba.dubbo.user.api.User;
import com.alibaba.dubbo.user.api.UserService;

/**
 *
 * @author Shunli
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String id) {
        User user = new User(id, "name" + id);
        return user;
    }
}
