package com.alibaba.dubbo.user.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderBootstrap {

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        context.start();

        System.in.read();
    }

}
