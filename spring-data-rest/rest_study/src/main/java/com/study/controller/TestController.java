package com.study.controller;

import com.study.entity.Test;
import com.study.entity.User;
import com.study.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {
    @Autowired
    private TestRepository test;
    @RequestMapping("/test/{id}")
    public String hello(@PathVariable("id")Integer id){
        Optional<Test> byId = test.findById(id);
        return byId.get().getName();
    }
}
