package com.springBootExamples.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before("execution(* com.springBootExamples.service.MessageService.sendMessage(..))")
    public void beforeSentMessage(JoinPoint joinPoint) {
        System.out.println("Parameter caught before give message method. param:  " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.springBootExamples.service.*.*(..))")
    public void afterSentMessage(JoinPoint joinPoint) {
        System.out.println("Parameter caught after give message method. param:" + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
