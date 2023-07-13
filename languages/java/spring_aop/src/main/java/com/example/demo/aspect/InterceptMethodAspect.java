package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InterceptMethodAspect {
    // Method-level pointcut
    @Before("@annotation(com.example.demo.annotation.InterceptMethod)")
    public void beforeAdvice() {
        System.out.println("before method");
    }
}
