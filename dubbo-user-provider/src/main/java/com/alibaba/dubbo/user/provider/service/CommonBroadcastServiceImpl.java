package com.alibaba.dubbo.user.provider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.user.api.CommonBroadcastService;

/**
 *
 * @author Shunli
 */
public class CommonBroadcastServiceImpl implements CommonBroadcastService {
    private static final Logger log = LoggerFactory.getLogger(CommonBroadcastService.class);

    @Override
    public void refreshCache() {
        System.out.println(RpcContext.getContext().getLocalAddressString() + " CommonBroadcastService.refreshCache() invoked");
        log.info("{} invoked", "CommonBroadcastService.refreshCache()");
        log.warn("test {}", "warning");
        log.error("test logback", new RuntimeException("xxxx"));

        throw new RuntimeException("test dubbo exception");
    }

}
