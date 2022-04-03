package com.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.controllers.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.services.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();

		logger.info("\n==========>>> Calling method " + method);
		
		

	}

}
