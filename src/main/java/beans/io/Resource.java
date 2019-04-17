package beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 资源接口
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public interface Resource
{
    InputStream getInputStream() throws IOException;
}
