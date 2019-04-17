package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * 拦截器(Advice)
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class TimerInterceptor implements MethodInterceptor
{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
    {
		long time = System.nanoTime();
		System.out.println("Invocation of Method " + invocation.getMethod().getName() + " start!");
		Object proceed = invocation.proceed();
		System.out.println("Invocation of Method " + invocation.getMethod().getName() + " end! takes " + (System.nanoTime() - time)
				+ " nanoseconds.");
		return proceed;
	}
}
