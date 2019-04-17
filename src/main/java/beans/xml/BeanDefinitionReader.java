package beans.xml;

/**
 *
 * 从配置中读取BeanDefinition
 * 接口
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public interface BeanDefinitionReader
{
    void loadBeanDefinitions(String location) throws Exception;
}
