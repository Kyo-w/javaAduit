package com.study.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "list",types = User.class)
public interface UserRest {
    String getName();
    long getId();
}
