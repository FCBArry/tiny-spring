package beans;

/**
 *
 * test log测试
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class BeanInitializeLogger implements BeanPostProcessor
{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception
    {
		System.out.println("Initialize bean " + beanName + " start!");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception
    {
		System.out.println("Initialize bean " + beanName + " end!");
		return bean;
	}
}
