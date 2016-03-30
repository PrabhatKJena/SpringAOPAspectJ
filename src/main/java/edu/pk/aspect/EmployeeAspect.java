package edu.pk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {
    @Before("execution(* edu.pk.service.EmployeeService.*(..))")
    public void entryLog(JoinPoint point) {
        System.out.println(">>>> Logging Before " + point.getSignature());
    }

    @After("execution(* edu.pk.service.EmployeeService.*(..))")
    public void exitLog(JoinPoint point) {
        System.out.println(">>>> Logging After...." + point.getSignature());
    }

    @AfterReturning(pointcut = "execution(* edu.pk.service.EmployeeService.getEmployee(*))", returning = "r")
    public void returnResultLog(JoinPoint joinPoint, Object r) {
        System.out.println(">>>> Returned Result : " + r);
    }

    @AfterThrowing(pointcut = "execution(* edu.pk.service.EmployeeService.*(..))", throwing = "exp")
    public void logOnException(JoinPoint joinPoint, Throwable exp) {
        System.out.println(">>>> Exception Thrown : " + exp);
    }
}
