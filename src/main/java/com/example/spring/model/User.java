package com.example.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements ApplicationContextAware, BeanNameAware {
    private String username;

    private String password;

    private int sex;

    private Emp emp;

    private ApplicationContext applicationContext;
    private String name;
//    private static  User user = new User();

    @Override
    public void setBeanName(String name){
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException{
        this.applicationContext = applicationContext;
    }

    public User(String username, String password, int sex, Emp emp) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.emp = emp;
    }

//Static Factory Method
//    public static User createInstance(){
//        System.out.println("User has init by StaticFactory");
//        return user;
//    }

    @PostConstruct
    public void init(){
//        System.out.println(applicationContext.getBean("User",User.class));
        System.out.println(" invoke init() ... " + name);
    }

    @PreDestroy
    public void destroy(){
        System.out.println(" invoke destroy() ... " + name);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Emp getEmp() {
        return emp;
    }

    @Override
    public String toString(){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        if(sex == 1){
            System.out.println("sex:男");
        }else{
            System.out.println("sex:女");
        }
        System.out.println("emp:"+emp);
        return "Hello Spring ...";
    }
}

//Instance Factory Method
//class InstanceFactory{
//    private static User user = new User();
//
//    public User createInstance(){
//        System.out.println("User has init by InstanceFactory");
//        return user;
//    }
//}

