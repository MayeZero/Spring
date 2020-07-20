package com.example.spring.aop;

import com.example.spring.model.Emp;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class Aspect {
    public void before() {
        System.out.println("start invoking aop's before advice ...");
    }
    public void after() {
        System.out.println("start invoking aop's after advice ...");
    }
    public void afterThrowing(Exception e) {
        System.out.println("start invoking aop's afterThrowing advice, returns the exception：" + e.getMessage());
    }
    public void afterReturning(Object retValue) {
        System.out.println("start invoking aop's afterReturning advice, returns the value：" + retValue.toString());
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start invoking aop's around-before advice ...");
        System.out.println("Returns the method arguments：" +
                Arrays.toString(pjp.getArgs()));
        System.out.println("Returns the proxy object：" + pjp.getThis());
        System.out.println("Returns the target object：" + pjp.getTarget());
        System.out.println("Returns the method's description：" +
                pjp.getSignature());
// Object obj = pjp.proceed();
// System.out.println("Returns the adviced-method's value：" +obj.toString());
        System.out.println("start invoking aop's around-after advice ...");
// return obj;
        return new Emp(10086, "z");
    }
}
