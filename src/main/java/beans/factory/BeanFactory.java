package beans.factory;

/**
 *
 * bean的容器
 * 接口
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public interface BeanFactory
{
    Object getBean(String name) throws Exception;
}
