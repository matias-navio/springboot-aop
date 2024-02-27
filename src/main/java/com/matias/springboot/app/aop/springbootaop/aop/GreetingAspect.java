package com.matias.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //punto de corte donde se va a ejecutar el metodo, siempre execution(retorno package.clase.metodo(args))
    @Before("execution(String com.matias.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }
}
