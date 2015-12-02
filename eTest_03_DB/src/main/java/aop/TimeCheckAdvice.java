package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCheckAdvice {
	    private static final Logger LOGGER =
	    		LoggerFactory.getLogger("egovframework");
		
	    @Pointcut("execution(* user.service.UserService.login(..))")
		public void checking(){}
		
		@Around("checking()")
		public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
			Object obj = null;
			String method = pjp.getSignature().getName();
			long start = System.currentTimeMillis();
			obj = pjp.proceed();
			long end = System.currentTimeMillis();
			System.out.println(method + "() 메소드 수행에 걸린 시간 : "
					+ (end - start) + "ms(초)");
			return obj;
		}
		@Before(value="checking()")
		public void log(JoinPoint jp){
			Object[] obj = jp.getArgs();
			LOGGER.info("로그인 정보: "+obj[0]);
		}
	}

