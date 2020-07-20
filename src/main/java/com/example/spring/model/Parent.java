package com.example.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Parent implements BeanPostProcessor {
    String username;
    String password;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        if(beanName.equals("user")){
            System.out.println("BeforeInitialization: " + bean);
            return new User("g-code", null, 1, null);
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        if(beanName.equals("user")){
            System.out.println("AfterInitialization: " + bean);
            return new User("g-code", null, 2 ,null);
        }
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
