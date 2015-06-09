package com.alibaba.dubbo.user.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.user.api.CommonBroadcastService;

/**
 *
 * @author Shunli
 */
public class CommonBroadcastServiceImpl implements CommonBroadcastService {

    @Override
    public void refreshCache() {
        System.out.println(RpcContext.getContext().getLocalAddressString() + " CommonBroadcastService.refreshCache() invoked");
    }

}
