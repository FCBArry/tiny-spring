package beans;

/**
 *
 * 初始化周边工作
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public interface BeanPostProcessor
{
	Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

	Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}