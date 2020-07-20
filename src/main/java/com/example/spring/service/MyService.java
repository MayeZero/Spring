package com.example.spring.service;

import com.example.spring.model.Emp;
import org.springframework.stereotype.Component;

@Component("myService")
public class MyService {
    public Emp getEmps(int start, int pageSize, String sql){
        System.out.println("com.example.spring.service.MyService.getEmps start invoke ...."/* + 1 / 0*/);
        return new Emp(9527, "g-code");
    }
}
