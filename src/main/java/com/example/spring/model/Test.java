package com.example.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\study\\code\\J\\projects\\SpringProject\\src\\main\\resources\\application.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println(user);
    }
}
