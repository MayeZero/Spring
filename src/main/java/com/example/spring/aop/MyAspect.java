package com.example.spring.aop;
import com.example.spring.model.Emp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.example.spring.service.*.*(..))")
    private void myPoint() {
    }
    @Pointcut("within(com.example.spring.service.*)")
    private void testPoint() {
    }
    @Before("myPoint()")
    public void before() {
        System.out.println("start invoking aop's before advice ...");
    }
    @After("myPoint()")
    public void after() {
        System.out.println("start invoking aop's after advice ...");
    }
    @AfterThrowing(pointcut = "myPoint()", throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("start invoking aop's afterThrowing advice, returns the exception：" + e.getMessage());
    }
    @AfterReturning(pointcut = "myPoint()", returning = "retValue")
    public void afterReturning(Object retValue) {
        System.out.println("start invoking aop's afterReturning advice, returns the value：" + retValue.toString());
    }
    @Around("myPoint()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start invoking aop's around-before advice...");
        System.out.println("Returns the method arguments：" +
                Arrays.toString(pjp.getArgs()));
        System.out.println("Returns the proxy object：" + pjp.getThis());
        System.out.println("Returns the target object：" +
                pjp.getTarget());
        System.out.println("Returns the method's description：" +
                pjp.getSignature());
// Object obj = pjp.proceed();
// System.out.println("Returns the adviced-method's value：" +obj.toString());
        System.out.println("start invoking aop's around-after advice ...");
// return obj;
        return new Emp(10086,"g-code");
    }
}
