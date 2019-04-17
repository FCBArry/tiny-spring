package beans;

/**
 *
 * 用于为bean注入bean
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class BeanReference
{
    private String name;

    private Object bean;

    public BeanReference(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Object getBean()
    {
        return bean;
    }

    public void setBean(Object bean)
    {
        this.bean = bean;
    }
}
