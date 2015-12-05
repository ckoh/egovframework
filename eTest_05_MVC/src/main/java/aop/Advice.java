package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class Advice {
	
	@Pointcut("execution(* user.service.UserService.login(..))")
	public void pp(){}
	
	@AfterThrowing(pointcut="pp()",throwing="ex")
	public void log(JoinPoint jp,Exception ex) {
		System.out.println("*********** log **********");
		System.out.println(jp.getSignature().getName());
		System.out.println(ex.getMessage());
		System.out.println("**************************");
	}
	
	@Around("aop.Advice.pp()")
	public Object around(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("************* start *********");
		Object obj =  pp.proceed();
		System.out.println("************* end *********");
		
		return obj;
	}
}
