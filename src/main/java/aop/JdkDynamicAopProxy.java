package aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 基于JDK的动态代理
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler
{
    public JdkDynamicAopProxy(AdvisedSupport advised)
    {
        super(advised);
    }

	@Override
	public Object getProxy()
    {
		return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getInterfaces(), this);
	}

	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable
    {
		MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
		if (advised.getMethodMatcher() != null
				&& advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass()))
		{
			return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),
					method, args));
		}
		else
        {
			return method.invoke(advised.getTargetSource().getTarget(), args);
		}
	}
}
