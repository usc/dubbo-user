package com.alibaba.dubbo.user.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
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
        // int i = 0;
        // while (true) {
        // System.out.println(userService.getUser((i++) + ""));
        // }
        for (int i = 0; i < 10; i++) {
            System.out.println(RpcContext.getContext().getLocalAddressString() + " ==> " + userService.getUser(i + ""));
        }
    }
}
