package com.matias.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// esto le da prioridad a este aspecto por sobre los demas, dependiendo el numero
@Order(1)
@Aspect
@Component
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("GreetingServicePointcuts.greetingFooPointcut()")
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = joinPoint.getArgs().toString();
        logger.info("Before: metodo " + method + "() invocado con los parametros " + args);
    }

    @After("GreetingServicePointcuts.greetingFooPointcut()")
    public void loggerAfter(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = joinPoint.getArgs().toString();
        logger.info("After: metodo " + method + "() invocado con los parametros " + args);
    }
}
