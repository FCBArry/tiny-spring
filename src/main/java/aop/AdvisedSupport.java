package aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 *
 * 代理相关的元数据
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class AdvisedSupport
{
	private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource()
    {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource)
    {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor()
    {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor)
    {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher()
    {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher)
    {
        this.methodMatcher = methodMatcher;
    }
}
