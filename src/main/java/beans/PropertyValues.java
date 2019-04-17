package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 包装一个对象的所有PropertyValue，
 * 可以用list或者其他数据结构
 *
 * @author 科兴第一盖伦
 * @version 2019/4/15
 */
public class PropertyValues
{
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues()
    {

    }

    /**
     * 这里可以做额外处理
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv)
    {
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues()
    {
        return this.propertyValueList;
    }
}