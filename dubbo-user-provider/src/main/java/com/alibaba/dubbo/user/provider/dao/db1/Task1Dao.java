/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.alibaba.dubbo.user.provider.dao.db1;

import org.springframework.data.repository.CrudRepository;

import com.alibaba.dubbo.user.provider.model.Task1;

public interface Task1Dao extends CrudRepository<Task1, Long> {
    Iterable<Task1> findByTitleStartingWith(String title);
}
