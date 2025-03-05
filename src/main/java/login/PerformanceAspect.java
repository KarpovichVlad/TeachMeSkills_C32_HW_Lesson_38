package login;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* service.*.*(..)) || @annotation(TrackTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;

        if (duration > 1000 || joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName()).isAnnotationPresent(TrackTime.class)) {
            System.out.println("[AOP] Метод " + joinPoint.getSignature() + " выполнялся " + duration + " мс");
        }

        return result;
    }
}
