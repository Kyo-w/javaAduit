package com.test;

public class Debug {
    public static void line(){
        System.out.println("Hello Wolrd");
    }
    public static void detailline(){
        int i =2;
        int y = 23;
        System.out.println("Hello!!!");
    }

    public static void method(){
        int i =2;
        int y = 23;
        int result = i + y;
        System.out.println("Hello!!!");
    }

    public static void exception(){
        Object o = null;
        o.toString();
    }

    public static void field(){
        Person person = new Person("321", 22);
        person.setAge(321);
        System.out.println("the fire");
        person.setAge(77777777);
        }

    public static void method1(){
        method2();
    }

    public static void method2(){
        method3();
    }
    public static void method3(){

    }
    public static void main(String[] args) {
        //行断点
        line();
        //详细断点
        detailline();
        //方法断点
        method();
        //异常断点
        //exception();
        //字段断点
        field();
        method1();
    }
}