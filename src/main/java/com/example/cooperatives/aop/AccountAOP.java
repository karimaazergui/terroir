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
public class AccountAOP {

    @Pointcut("execution(* com.example.cooperatives.services.AccountService.*(..))")
    public void traceAccountPointCut(){}

    @Around("traceAccountPointCut()")
    public Object logAccountTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
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
        System.out.println(nomMethode + " "+ LocalDateTime.now() );
        return joinPoint.proceed();
    }
}
