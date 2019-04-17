package aop;

/**
 *
 * 代理工厂类
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy
{
	@Override
	public Object getProxy()
    {
		return createAopProxy().getProxy();
	}

	protected final AopProxy createAopProxy()
    {
		return new Cglib2AopProxy(this);
	}
}
