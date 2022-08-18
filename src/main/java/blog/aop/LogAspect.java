package blog.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect @Component
public class LogAspect {
	 Logger log=Logger.getLogger(LogAspect.class);

	@Pointcut("execution(* cat.controller.*.*(..))")  //切入点
	private void anyMethodAAA() {}

	@Around("anyMethodAAA()")
	public Object aroundMethod(ProceedingJoinPoint point) {
		Object result=null;
		
		log.trace("环绕通知: 前置通知触发了,并在这里记录了日志");
		String methodName=point.getSignature().getName();
		log.info("当前被拦到的方法是:"+methodName);
		
		try {
			result = point.proceed();
		}
		catch(Throwable ex) {
			log.error("环绕通知: 例外通知触发了,并在这里记录了日志");
			ex.printStackTrace();
		}
		finally {
			log.info("环绕通知: 最终通知触发了,并在这里记录了日志");
		}
		
		log.info("环绕通知: 后置通知触发了,并在这里记录了日志");
		
		return  result;
	}
}
