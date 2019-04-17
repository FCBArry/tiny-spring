package beans.factory;

import beans.BeanDefinition;
import beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * bean的容器
 * 抽象类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public abstract class AbstractBeanFactory implements BeanFactory
{
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	private final List<String> beanDefinitionNames = new ArrayList<String>();

	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

	@Override
	public Object getBean(String name) throws Exception
    {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if (beanDefinition == null)
		{
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		}

		Object bean = beanDefinition.getBean();
		if (bean == null)
		{
			bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean, name);
            beanDefinition.setBean(bean);
		}

		return bean;
	}

    private Object initializeBean(Object bean, String name) throws Exception
    {
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors)
		{
			bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
		}

        // TODO:call initialize method

		for (BeanPostProcessor beanPostProcessor : beanPostProcessors)
		{
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
		}

        return bean;
	}

	private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception
    {
		return beanDefinition.getBeanClass().newInstance();
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception
    {
		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);
	}

	public void preInstantiateSingletons() throws Exception
    {
        for (String beanName : this.beanDefinitionNames)
        {
            getBean(beanName);
        }
	}

	private Object doCreateBean(BeanDefinition beanDefinition) throws Exception
    {
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception
    {

	}

	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception
    {
		this.beanPostProcessors.add(beanPostProcessor);
	}

	public List getBeansForType(Class type) throws Exception
    {
		List beans = new ArrayList<>();
		for (String beanDefinitionName : beanDefinitionNames)
		{
			if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass()))
			{
				beans.add(getBean(beanDefinitionName));
			}
		}

		return beans;
	}
}
