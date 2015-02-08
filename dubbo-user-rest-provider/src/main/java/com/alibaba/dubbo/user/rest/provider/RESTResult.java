package com.alibaba.dubbo.user.rest.provider;

/**
 *
 * @author Shunli
 */
public class RESTResult implements java.io.Serializable {
    private static final long serialVersionUID = -110626687638078452L;

    public int code = 0;
    public Object result;

    public RESTResult() {
    }

    public RESTResult(int code) {
        this.code = code;
    }

    public RESTResult(int code, Object result) {
        this.code = code;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
