package com.alibaba.dubbo.user.provider;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*.xml")
public class ProviderTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void bootstrap() throws IOException {
        System.in.read();
    }

}
