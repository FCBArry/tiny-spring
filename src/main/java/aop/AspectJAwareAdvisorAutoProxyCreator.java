package aop;

import beans.BeanPostProcessor;
import beans.factory.AbstractBeanFactory;
import beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 *
 * AspectJ
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware
{
	private AbstractBeanFactory beanFactory;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception
	{
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception
    {
		if (bean instanceof AspectJExpressionPointcutAdvisor)
		{
			return bean;
		}

		if (bean instanceof MethodInterceptor)
		{
			return bean;
		}

		List<AspectJExpressionPointcutAdvisor> advisors = beanFactory
				.getBeansForType(AspectJExpressionPointcutAdvisor.class);
		for (AspectJExpressionPointcutAdvisor advisor : advisors)
		{
			if (advisor.getPointcut().getClassFilter().matches(bean.getClass()))
			{
                ProxyFactory advisedSupport = new ProxyFactory();
				advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
				advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

				TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
				advisedSupport.setTargetSource(targetSource);

				return advisedSupport.getProxy();
			}
		}

		return bean;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws Exception
    {
		this.beanFactory = (AbstractBeanFactory) beanFactory;
	}
}
