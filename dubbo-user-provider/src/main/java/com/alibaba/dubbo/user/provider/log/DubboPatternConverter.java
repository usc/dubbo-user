package com.alibaba.dubbo.user.provider.log;

import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.spi.LoggingEvent;

import com.alibaba.dubbo.rpc.RpcContext;

public class DubboPatternConverter extends PatternConverter {

    @Override
    protected String convert(LoggingEvent evt) {
        return RpcContext.getContext().getRemoteAddressString();
    }
}
