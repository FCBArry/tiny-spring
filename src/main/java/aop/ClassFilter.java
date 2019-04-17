package aop;

/**
 *
 * ClassFilter
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public interface ClassFilter
{
    boolean matches(Class targetClass);
}
