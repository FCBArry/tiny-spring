package beans.xml;

import beans.BeanDefinition;
import beans.BeanReference;
import beans.PropertyValue;
import beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 *
 * 从xml配置中读取BeanDefinition
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader
{
    public XmlBeanDefinitionReader(ResourceLoader resourceLoader)
    {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception
    {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);

        // 解析bean
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document doc)
    {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root)
    {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++)
        {
            Node node = nl.item(i);
            if (node instanceof Element)
            {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele)
    {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition)
    {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++)
        {
            Node node = propertyNode.item(i);
            if (node instanceof Element)
            {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0)
                {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                }
                else
                {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0)
                    {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }

                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }
}
