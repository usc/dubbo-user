/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.alibaba.dubbo.user.provider.model;

import javax.persistence.Entity;
import javax.persistence.Table;

//JPA标识
@Entity
@Table(name = "ss_task")
public class Task1 extends IdEntity {

    private String title;
    private String description;
    private String extText;

    public Task1() {
    }

    public Task1(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Task1(String title, String description, String extText) {
        this.title = title;
        this.description = description;
        this.extText = extText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtText() {
        return extText;
    }

    public void setExtText(String extText) {
        this.extText = extText;
    }

}
