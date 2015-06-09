package com.alibaba.dubbo.user.consumer;

import com.alibaba.dubbo.user.api.CommonBroadcastService;
import com.alibaba.dubbo.user.api.UserService;

/**
 *
 * @author Shunli
 */
public class Action {
    private UserService userService;
    private CommonBroadcastService commonBroadcastService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setCommonBroadcastService(CommonBroadcastService commonBroadcastService) {
        this.commonBroadcastService = commonBroadcastService;
    }

    public void start() throws Exception {
        // int i = 0;
        // while (true) {
        // System.out.println(userService.getUser((i++) + ""));
        // }
        // for (int i = 0; i < 10; i++) {
        // System.out.println(RpcContext.getContext().getLocalAddressString() + " ==> " + userService.getUser(i + ""));
        // }

        System.out.println(userService.getUser("1"));

        commonBroadcastService.refreshCache();
    }
}
