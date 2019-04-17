package context;

import beans.BeanDefinition;
import beans.factory.AbstractBeanFactory;
import beans.factory.AutowireCapableBeanFactory;
import beans.io.ResourceLoader;
import beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *
 * ApplicationContext
 * 工具整合类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext
{
	private String configLocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception
	{
		this(configLocation, new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception
	{
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception
	{
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet())
		{
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}
}
