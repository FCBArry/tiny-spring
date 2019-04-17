package aop;

import beans.factory.BeanFactory;

/**
 *
 * BeanFactoryAware
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public interface BeanFactoryAware
{
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
