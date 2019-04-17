package aop;

import beans.HelloWorldService;
import beans.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 使用AspectJ管理切面
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class AspectJExpressionPointcutTest
{
    @Test
    public void testClassFilter() throws Exception
    {
        String expression = "execution(* *.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception
    {
        String expression = "execution(* *.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher()
                .matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
