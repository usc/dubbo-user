package com.alibaba.dubbo.user.consumer;

import com.alibaba.dubbo.user.api.UserService;

/**
 *
 * @author Shunli
 */
public class Action {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void start() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(userService.getUser(i + ""));
        }
    }
}
