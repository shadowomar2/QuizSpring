package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SaleLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(SaleLoggingAspect.class);

    @Before("execution(* com.example.demo.services.SalesService.*(..))")
    public void logMethodStart(JoinPoint joinPoint) {
        logger.info("Executing method: {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.services.SalesService.*(..))", returning = "result")
    public void logMethodReturn(JoinPoint joinPoint, Object result) {
        logger.info("Method executed: {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        logger.info("Result: {}", result);
    }
}
