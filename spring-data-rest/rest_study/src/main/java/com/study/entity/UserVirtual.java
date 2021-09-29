package com.study.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "virtual", types = User.class)
public interface UserVirtual {
    @Value("name:#{target.name}, age:#{target.age}")
    String getFullInfo();
}
