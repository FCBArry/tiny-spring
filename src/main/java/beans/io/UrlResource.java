package beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * url方式
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class UrlResource implements Resource
{
    private final URL url;

    public UrlResource(URL url)
    {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException
    {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
