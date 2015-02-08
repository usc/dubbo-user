package com.alibaba.dubbo.user.rest.provider;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Shunli
 */
public interface UserRestService {
    public RESTResult getUser(@NotEmpty(message = "id must not empty") String id);
}
