package com.matias.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());    

    // reutilizamos el punto de corte con el metodo greetingLoggerPointcut(), que se encuentra en otra clase
    // pero lo podemos usar gracias a la anotacion @Aspect
    @Before("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before: " + method + " con los argumentos " + args);
    }

    // se va a ejecutar despues de ejecutar el metodo
    @After("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: " + method + " con los argumentos " + args);
    }

    // se ejecuta despues siempre y cuando no hallan errores
    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterReturning: " + method + " con los argumentos " + args);
    }

    // se ejecuta luego de una excepcion
    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterThowing: " + method + " con los argumentos " + args);
    }

    // podemos ejecutar antes y despues de realizar alguna operacion
    @Around("GreetingServicePointcuts.greetingLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint point){

        String method = point.getSignature().getName();
        String args = Arrays.toString(point.getArgs());

        Object result = null;
        try {
            logger.info("Around antes del metodo " + method + "() con los argumentos " + args);
            result = point.proceed();
            logger.info("Around despues del metodo" + method + "() retorna el resultado " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Around error de ejecucion del metodo " + method + "()");
        }
        
        return result;
    }
}
