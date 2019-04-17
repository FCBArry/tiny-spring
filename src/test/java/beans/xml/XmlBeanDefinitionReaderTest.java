package beans.xml;

import beans.BeanDefinition;
import beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 *
 * xml reader测试
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class XmlBeanDefinitionReaderTest
{
	@Test
	public void test() throws Exception
    {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}
}
