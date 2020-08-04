package com.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAnnotationAspect {
    @Pointcut("execution(* com.classes.Person.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("annotation before advice");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("annotation after advice");
    }

    @AfterReturning(value = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("annotation after return: " + retVal.toString());
    }

    @AfterThrowing(value = "selectAll()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("annotation after throwing advice: " + ex.toString());
    }

    @Around(value = "selectAll()")
    private Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("annotation around advice: before");

        Object object = jp.proceed();

        System.out.println("annotation around advice: after");
        return object;
    }
}
