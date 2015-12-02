package aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 시간 체크
 * @author student
 *
 */
@Component
@Aspect
public class TimeCheckAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeCheckAdvice.class);

	@Pointcut("execution(* user.service.UserService.login(..))")
	public void checking() {

	}
	
	@Pointcut("execution(* user.service.UserService.login(..))")
	public void logging() {

	}
	
	

	@Around(value = "checking()")
	public Object timeCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long currentTimeMillisStart = System.currentTimeMillis();
		
		System.out.println(" ********* Advice around start ********* ");
		
		Object proceed = proceedingJoinPoint.proceed();

		System.out.println("proceed : " + proceed);
		
		System.out.println(" ********* Advice around end ********* ");
		
		long currentTimeMillisEnd = System.currentTimeMillis();
		
		// new Date((((System.currentTimeMillis()/1000/60/60+9)/24))*24+9)*60*60*1000);
		
		System.out.println("시작시간 : " + new Date(currentTimeMillisStart));
		System.out.println("시작시간 : " + new Date(currentTimeMillisEnd));
		System.out.println("시작시간 : " + ((currentTimeMillisEnd-currentTimeMillisStart)/1000.0) + "초");
		
		return proceed;
	}
	
	@Before(value="logging()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before logging");
		LOGGER.info((String)joinPoint.getArgs()[0]);
	}
}
