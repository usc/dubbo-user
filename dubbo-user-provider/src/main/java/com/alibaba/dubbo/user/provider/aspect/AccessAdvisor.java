package com.alibaba.dubbo.user.provider.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcContext;
import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class AccessAdvisor {
    private Logger log = LoggerFactory.getLogger("access");

    public Object invoke(ProceedingJoinPoint jp) throws Throwable {
        Stopwatch sw = Stopwatch.createStarted();

        Object proceed = null;
        try {
            proceed = jp.proceed(); // execute
        } finally {
            RpcContext context = RpcContext.getContext();
            String request = jp.getSignature().toShortString() + Arrays.toString(jp.getArgs());
            log.debug("[1]channel:{} -> {}, request:{}, respone:{}, elapsed:{}", context.getRemoteAddressString(), context.getLocalAddressString(), request, proceed, sw);
        }

        return proceed;
    }
}
