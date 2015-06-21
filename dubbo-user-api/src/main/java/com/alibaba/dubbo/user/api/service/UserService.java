package com.alibaba.dubbo.user.api.service;

import com.alibaba.dubbo.user.api.domain.User;

/**
 *
 * @author Shunli
 */
public interface UserService {
    public User getUser(String id);
}
