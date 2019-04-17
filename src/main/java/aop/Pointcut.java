package aop;

/**
 *
 * Pointcut
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public interface Pointcut
{
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
