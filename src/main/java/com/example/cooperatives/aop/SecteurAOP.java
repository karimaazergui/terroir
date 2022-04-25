package com.example.cooperatives.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Configuration
public class SecteurAOP {

    @Pointcut("execution(* com.example.cooperatives.services.SecteurService.*(..))")
    public void traceSecteurPointCut(){}

    @Around("traceSecteurPointCut()")
    public Object logSecteurTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        String s = " id = " + Arrays.toString(args);

        String nomMethode;
        if (args.length == 0){
            nomMethode = joinPoint.getTarget().getClass().getSimpleName() + "."
                    + joinPoint.getSignature().getName();
        }else {
            nomMethode = joinPoint.getTarget().getClass().getSimpleName() + "."
                    + joinPoint.getSignature().getName() + s;
        }
        System.out.println(nomMethode + " "+ LocalDateTime.now().toString() );
        return joinPoint.proceed();
    }
}
