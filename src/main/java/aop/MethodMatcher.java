package aop;

import java.lang.reflect.Method;

/**
 *
 * MethodMatcher
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public interface MethodMatcher
{
    boolean matches(Method method, Class targetClass);
}
