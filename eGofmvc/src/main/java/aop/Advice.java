package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
	
	@Pointcut("execution(* user.service.UserService.login(..))")
	public void pointcut(){
		System.out.println("Advice pointcut");
	}
	
	public void before(JoinPoint joinPoint) {
		
		System.out.println("Advice log *******");
		
		System.out.println(joinPoint.getArgs());
		
		Object[] args = joinPoint.getArgs();
		
		for (Object object : args) {
			System.out.println(args);
		}
	}
	
	/*@AfterReturning*/
	public void  after_returning(JoinPoint joinPoint, Object obj) {
		System.out.println("Advice after_returning  *******");
		System.out.println(obj);
	}
	
	
	public void  after(JoinPoint joinPoint) {
		System.out.println("Advice after  *******");
		System.out.println(joinPoint);
	}
	
	
	/*@AfterThrowing(pointcut="pointcut()", throwing="ex")*/
	public void  after_throwing(JoinPoint joinPoint, Exception ex) {
		System.out.println("Advice after_throwing  *******");
		System.out.println(ex);
	}
	
	/**
	 * 패키지 생략
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	/*@Around(value="aop.Advice.pointcut()")*/
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println(" ********* Advice around start ********* ");
		
		Object proceed = joinPoint.proceed();
		
		System.out.println("proceed : " + proceed);
		
		System.out.println(" ********* Advice around end ********* ");
		
		return  proceed;
		
	}
}
