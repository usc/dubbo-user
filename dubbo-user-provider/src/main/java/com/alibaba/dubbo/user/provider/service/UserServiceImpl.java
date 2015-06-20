package com.alibaba.dubbo.user.provider.service;

import javax.annotation.Resource;

import org.apache.commons.configuration.XMLConfiguration;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.user.api.User;
import com.alibaba.dubbo.user.api.UserService;

/**
 *
 * @author Shunli
 */
public class UserServiceImpl implements UserService {

    @Resource(name = "userConfig")
    private XMLConfiguration config;

    @Override
    public User getUser(String id) {
        System.out.println(RpcContext.getContext().getLocalAddressString() + " UserService.getUser() invoked");

        System.out.println(config.getString("db.name"));

        User user = new User(id, "name" + id);
        return user;
    }
}
