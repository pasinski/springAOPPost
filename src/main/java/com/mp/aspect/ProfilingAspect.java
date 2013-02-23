package com.mp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * User: Michal
 * Date: 23.02.13
 * Time: 12:49
 */

@Component
@Aspect
public class ProfilingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilingAspect.class);

    @Pointcut("execution( * com.mp.intercepted..*(..) )")
    public void profilingPointcut() {}

    @Pointcut("execution( * com.mp.nestedintercepted..nested(..) )")
    public void nestedPointcut() {}

    @Around("profilingPointcut()")
    public String logProfileInfo(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String result = "";
        try {
            result = String.valueOf(joinPoint.proceed());
        } catch (Throwable throwable) {
            LOGGER.error(String.format("Error when executing original method [%s]", methodName), throwable);
            stopWatch.stop();
            LOGGER.debug(String.format("Elapsed time when error occured executing method[%s] : [%s]", methodName, stopWatch));
            if(throwable instanceof Error){
                throw (Error)throwable;
            }
        }
        stopWatch.stop();
        LOGGER.debug(String.format("Elapsed time executing method [%s]: [%s]", methodName, stopWatch));
        return "Intercepted: " + result;
    }

    @Around("nestedPointcut()")
    public int addOneToOriginalResult(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        int result = 0;
        try{
            result = (Integer)joinPoint.proceed();
            result += 1;
        } catch (Throwable t){
            LOGGER.error(String.format("Error when executing original method [%s]", methodName), t);
            if(t instanceof Error){
                throw (Error)t;
            }
        }
        return result;
    }
}
