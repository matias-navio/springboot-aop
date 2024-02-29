package com.matias.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.matias.springboot.app.aop.springbootaop.services.*.*(..))")
    public void greetingLoggerPointcut(){}

    @Pointcut("execution(* com.matias.springboot.app.aop.springbootaop.services.*.*(..))")
    public void greetingFooPointcut(){}
}
