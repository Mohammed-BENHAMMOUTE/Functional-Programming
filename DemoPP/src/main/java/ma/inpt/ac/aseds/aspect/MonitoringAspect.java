package ma.inpt.ac.aseds.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {
    
@Around("execution(* ma.inpt.ac.aseds.controller..*.*(..))")    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        System.out.println("Method " + joinPoint.getSignature().getName() + 
                         " took " + (endTime - startTime) + "ms to execute");
        
        return result;
    }
}