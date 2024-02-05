package ru.spring.hw6task1.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class LogingToConsoleUserAction {

    @Around("@annotation(ru.spring.hw6task1.aspect.TrackUserAction)")
    public Object actionLoger(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println(" - Runing "+joinPoint.getSignature());

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println(" - Executing time " + executionTime + "ms");

        return proceed;
    }
}
