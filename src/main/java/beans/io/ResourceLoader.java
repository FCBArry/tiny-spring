package beans.io;

import java.net.URL;

/**
 *
 * 资源加载类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class ResourceLoader
{
    /**
     * url方式
     */
    public Resource getResource(String location)
    {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
