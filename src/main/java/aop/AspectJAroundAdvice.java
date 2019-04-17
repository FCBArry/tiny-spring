package aop;

import beans.factory.BeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 *
 * AspectJ
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class AspectJAroundAdvice implements Advice, MethodInterceptor
{
	private BeanFactory beanFactory;

	private Method aspectJAdviceMethod;

	private String aspectInstanceName;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
    {
        return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectInstanceName), invocation);
	}

    public BeanFactory getBeanFactory()
    {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory)
    {
        this.beanFactory = beanFactory;
    }

    public Method getAspectJAdviceMethod()
    {
        return aspectJAdviceMethod;
    }

    public void setAspectJAdviceMethod(Method aspectJAdviceMethod)
    {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
    }

    public String getAspectInstanceName()
    {
        return aspectInstanceName;
    }

    public void setAspectInstanceName(String aspectInstanceName)
    {
        this.aspectInstanceName = aspectInstanceName;
    }
}
