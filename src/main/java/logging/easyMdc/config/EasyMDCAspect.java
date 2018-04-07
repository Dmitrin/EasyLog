package logging.easyMdc.config;

import logging.easyMdc.annotations.EasyMdc;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;

@Aspect
public class EasyMDCAspect {

    @Around("@annotation(easyMdc)")
    public Object around(ProceedingJoinPoint pjp, EasyMdc easyMdc) throws Throwable {

        System.out.println("===> Started!");

        MDC.put("it works", "yea!");
        long before = System.nanoTime();

        Object result = pjp.proceed();

        long after = System.nanoTime();
        System.out.println("Method work time: " + String.valueOf(after-before));
        MDC.remove("it works");

        System.out.println("<=== Finished!");

        return result;
    }

}
