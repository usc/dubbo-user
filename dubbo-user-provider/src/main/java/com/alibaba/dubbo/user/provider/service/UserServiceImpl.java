package com.alibaba.dubbo.user.provider.service;

import javax.annotation.Resource;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.user.api.domain.User;
import com.alibaba.dubbo.user.api.service.UserService;
import com.alibaba.dubbo.user.provider.dao.db1.Task1Dao;
import com.alibaba.dubbo.user.provider.dao.db2.Task2Dao;
import com.alibaba.dubbo.user.provider.model.Task1;
import com.alibaba.dubbo.user.provider.model.Task2;

/**
 *
 * @author Shunli
 */
public class UserServiceImpl implements UserService {

    @Resource(name = "userConfig")
    private XMLConfiguration config;

    @Autowired
    private Task1Dao task1Dao;

    @Autowired
    private Task2Dao task2Dao;

    @Override
    public User getUser(String id) {
        System.out.println(RpcContext.getContext().getLocalAddressString() + " UserService.getUser() invoked");

        System.out.println(config.getString("db.name"));

        task1Dao.save(new Task1("t1_" + random(), "d1_" + random(), "eT_" + random()));
        task2Dao.save(new Task2("t2_" + random(), "d2_" + random()));

        System.out.println(task1Dao.findByTitleStartingWith("t1_C"));
        System.out.println(task1Dao.findOne(1L));
        System.out.println(task1Dao.findAll());

        User user = new User(id, "name" + id);
        return user;
    }

    private String random() {
        return RandomStringUtils.randomAlphanumeric(6);
    }
}
