package com.alibaba.dubbo.user.provider.log;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternParser;

public class DubboPatternLayout extends PatternLayout {

    @Override
    protected PatternParser createPatternParser(String pattern) {
        return new DubboPatternParser(pattern);
    }
}
