package beans.factory;

import aop.BeanFactoryAware;
import beans.BeanDefinition;
import beans.BeanReference;
import beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * 注册bean
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory
{
	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception
	{
		if (bean instanceof BeanFactoryAware)
		{
			((BeanFactoryAware) bean).setBeanFactory(this);
		}

		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues())
		{
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference)
			{
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}

			try
			{
				// 反射设置值
				Method declaredMethod = bean.getClass().getDeclaredMethod(
						"set" + propertyValue.getName().substring(0, 1).toUpperCase()
								+ propertyValue.getName().substring(1), value.getClass());
				declaredMethod.setAccessible(true);

				declaredMethod.invoke(bean, value);
			}
			catch (NoSuchMethodException e)
			{
				Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}
}
