package com.xiwei.demo;

import sun.reflect.annotation.AnnotationType;

import java.lang.annotation.Inherited;
import java.util.Iterator;
import java.util.Map;

public class TestAnnotation {
    public static void main(String[] args) {
//        自定义注解
        Map stringClassMap = AnnotationType.getInstance(Annotation.class).memberTypes();
        Iterator iterator = stringClassMap.entrySet().iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
