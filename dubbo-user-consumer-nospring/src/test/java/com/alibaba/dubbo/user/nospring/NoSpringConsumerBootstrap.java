package com.alibaba.dubbo.user.nospring;

import com.alibaba.dubbo.user.api.UserService;

public class NoSpringConsumerBootstrap {

    public static void main(String[] args) {
        UserService userService = DubboServicesFactory.getService(UserService.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(userService.getUser(i + ""));
        }
    }

}
