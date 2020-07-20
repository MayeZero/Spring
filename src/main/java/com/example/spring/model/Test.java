package com.example.spring.model;

import com.example.spring.aop.Aspect;
import com.example.spring.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        ApplicationContext aop = new ClassPathXmlApplicationContext("aop.xml");
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\study\\code\\J\\projects\\SpringProject\\src\\main\\resources\\application.xml");
//        User user = ctx.getBean("user", User.class);
        Parent parent = ctx.getBean("parent", Parent.class);
        Children children = ctx.getBean("children", Children.class);
        MyService myService = ctx.getBean("myService", MyService.class);
//        System.out.println(user);
        System.out.println(parent);
        System.out.println(children);
        Emp emp = myService.getEmps(0, 10, "select * from emp");
        System.out.println(emp.getEmpno());

        MyService myService1 = aop.getBean("myService", MyService.class);
        Emp emp1 = myService1.getEmps(0, 10, "select * from emp");
        System.out.println(emp1.getEmpno());
    }
}
