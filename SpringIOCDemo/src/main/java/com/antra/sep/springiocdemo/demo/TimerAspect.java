package com.antra.sep.springiocdemo.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

    @Around("@annotation(Timer))")
    public Object timerHandler(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Now starting method " + proceedingJoinPoint.getSignature().getName());
        if (proceedingJoinPoint.getArgs().length > 0) {
            System.out.println(proceedingJoinPoint.getArgs()[0] + " ms will be used.");
        }
        long start = System.nanoTime();
        Object ret;
        try {
            ret = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("Time used : " + (System.nanoTime() - start));
        return ret;
    }

}
