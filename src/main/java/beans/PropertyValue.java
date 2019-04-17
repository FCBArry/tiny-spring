package beans;

/**
 *
 * 用于属性注入
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class PropertyValue
{
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public Object getValue()
    {
        return value;
    }
}
