package beans.xml;

import beans.BeanDefinition;
import beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 从配置中读取BeanDefinition
 * 抽象类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader
{
    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader)
    {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry()
    {
        return registry;
    }

    public ResourceLoader getResourceLoader()
    {
        return resourceLoader;
    }
}
