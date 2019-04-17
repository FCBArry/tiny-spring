package context;

import beans.HelloWorldService;
import org.junit.Test;

/**
 *
 * ApplicationContext test测试
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class ApplicationContextTest
{
    @Test
    public void test() throws Exception
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPostBeanProcessor() throws Exception
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc-postbeanprocessor.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
