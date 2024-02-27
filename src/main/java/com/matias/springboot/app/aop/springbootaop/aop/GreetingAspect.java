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
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //punto de corte donde se va a ejecutar, antes del metodo indicado en la ruta, siempre execution(retorno package.clase.metodo(args))
    @Before("execution(* com.matias.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    // punto de corte que se va a ejecutar despues de ejecutar el metodo
    @After("execution(* com.matias.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    // punto de corte que se ejecuta despues siempre y cuando no hallan errores
    @AfterReturning("execution(* com.matias.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
    public void loggerAfterReturning(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    // punto de corte que se ejecuta luego de una excepcion
    @AfterThrowing("execution(* com.matias.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint){

        // obtenemos el nombre y argumentos del metodo
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de una excepcion: " + method + " con los argumentos " + args);
    }

    @Around("execution(* com.matias.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public Object loggerAround(ProceedingJoinPoint point){

        String method = point.getSignature().getName();
        String args = Arrays.toString(point.getArgs());

        Object result = null;
        try {
            logger.info("Around antes del metodo " + method + "() con los argumentos " + args);
            result = point.proceed();
            logger.info("Around " + method + "() retorna el resultado " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error de ejecucion del metodo " + method + "()");
        }
        
        return result;
    }
}
