package beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 资源加载类测试
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class ResourceLoaderTest
{
	@Test
	public void test() throws IOException
    {
		ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
