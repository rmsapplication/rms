package com.app.rms.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author NT00477646
 *	LoggingAspect to log every action in every method.
 */
@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	/**
	 * Logging for controller layer
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("execution(* com.app.rms.controller.*.*(..))")
	public void controllerLogger(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("Entering:: "+ joinPoint.getSignature().toShortString());
	}
	
	/**
	 * Logging for controller layer
	 * @param joinPoint
	 * @throws Throwable
	 */
	@AfterReturning(pointcut = "execution(* com.app.rms.controller.*.*(..))")
	public void controllerLoggerAfterReturning(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("Exiting:: "+joinPoint.getSignature().toShortString());
	}
	
	/**
	 * Logging for service layer
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("execution(* com.app.rms.service.*.*(..))")
	public void serviceLogger(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("Entering:: "+ joinPoint.getSignature().toShortString());
	}
	
	/**
	 * Logging for service layer
	 * @param joinPoint
	 * @throws Throwable
	 */
	@AfterReturning(pointcut = "execution(* com.app.rms.service.*.*(..))")
	public void serviceLoggerAfterReturning(JoinPoint joinPoint) throws Throwable {
		LOGGER.info("Exiting:: "+joinPoint.getSignature().toShortString());
	}
	
	/**
	 * Logging for dao layer
	 * @param joinPoint
	 * @throws Throwable
	 */
	/*@Around("execution(* com.app.rms.dao.*.*(..))")
	public void daoLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("Entering:: "+ joinPoint.getSignature().toShortString());
		joinPoint.proceed();
		LOGGER.info("Exiting:: "+joinPoint.getSignature().toShortString());
	}*/
	
	
}
