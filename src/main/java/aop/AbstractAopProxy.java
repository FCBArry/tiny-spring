package aop;

/**
 *
 * AOP代理
 * 抽象类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public abstract class AbstractAopProxy implements AopProxy
{
    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised)
    {
        this.advised = advised;
    }
}
