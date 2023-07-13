package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
// The aspect should be discoverable by the Spring Context
@Component
public class InterceptClassAspect {
    // Class-level pointcut
    @Pointcut("@within(com.example.demo.annotation.InterceptClass)")
    public void pointcut(){};

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around: before class");

//        The result returned by the intercepted method can be completely modified
//        return "yes";

        return joinPoint.proceed();
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before class");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after class");
    }
}
