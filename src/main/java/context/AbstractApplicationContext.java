package context;

import beans.BeanPostProcessor;
import beans.factory.AbstractBeanFactory;

import java.util.List;


/**
 *
 * ApplicationContext
 * 抽象类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public abstract class AbstractApplicationContext implements ApplicationContext
{
	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory)
    {
		this.beanFactory = beanFactory;
	}

	public void refresh() throws Exception
    {
		loadBeanDefinitions(beanFactory);
		registerBeanPostProcessors(beanFactory);
		onRefresh();
	}

	protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

	protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception
    {
		List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
		for (Object beanPostProcessor : beanPostProcessors)
		{
			beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
		}
	}

	protected void onRefresh() throws Exception
    {
        beanFactory.preInstantiateSingletons();
    }

	@Override
	public Object getBean(String name) throws Exception
    {
		return beanFactory.getBean(name);
	}
}
