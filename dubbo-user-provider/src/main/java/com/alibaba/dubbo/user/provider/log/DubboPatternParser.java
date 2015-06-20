package com.alibaba.dubbo.user.provider.log;

import org.apache.log4j.helpers.PatternParser;

public class DubboPatternParser extends PatternParser {
    private static final char REMOTE_ADDRESS_CHAR = 'R';

    public DubboPatternParser(String pattern) {
        super(pattern);
    }

    @Override
    protected void finalizeConverter(char c) {
        switch (c) {
        case REMOTE_ADDRESS_CHAR:
            currentLiteral.setLength(0);
            addConverter(new DubboPatternConverter());
            break;
        default:
            super.finalizeConverter(c);
        }
    }
}
