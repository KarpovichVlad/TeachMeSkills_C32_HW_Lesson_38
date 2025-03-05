package login;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("[AOP] Начало метода: " + joinPoint.getSignature());
    }

    @After("execution(* service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("[AOP] Метод завершён: " + joinPoint.getSignature());
    }
}