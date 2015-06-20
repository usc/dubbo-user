package com.alibaba.dubbo.user.provider.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.RpcContext;
import com.google.common.base.Stopwatch;

@Aspect
@Component("systemAdvisor")
public class SystemAdvisor {
    private Logger log = LoggerFactory.getLogger("access");

    @Around("execution(* com.alibaba.dubbo.user.provider.service.*.*(..))")
    public Object executeControllerNormalFlow(ProceedingJoinPoint jp) throws Throwable {
        Stopwatch sw = Stopwatch.createStarted();

        Object respone = null;
        try {
            respone = jp.proceed(); // execute
        } finally {
            RpcContext context = RpcContext.getContext();
            String request = jp.getSignature().toShortString() + Arrays.toString(jp.getArgs());
            log.debug("[2]channel:{} -> {}, request:{}, respone:{}, elapsed:{}", context.getRemoteAddressString(), context.getLocalAddressString(), request, respone, sw);
        }

        return respone;
    }
}
