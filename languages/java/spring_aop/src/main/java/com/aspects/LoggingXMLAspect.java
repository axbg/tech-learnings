package com.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingXMLAspect {
    public void beforeAdvice() {
        System.out.println("xml before advice");
    }

    public void afterAdvice() {
        System.out.println("xml after advice");
    }

    public void afterReturningAdvice(Object retVal) {
        System.out.println("xml after return: " + retVal.toString());
    }

    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("xml after throwing advice: " + ex.toString());
    }

    private Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("xml around advice: before");
        Object object = jp.proceed();
        System.out.println("xml around advice: after");
        return object;
    }
}
