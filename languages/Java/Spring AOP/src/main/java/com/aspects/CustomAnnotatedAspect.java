package com.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CustomAnnotatedAspect {

    @Before("@annotation(com.annotations.Logged)")
    public void beforeAdvice() {
        System.out.println("custom annotation before");
    }
}
