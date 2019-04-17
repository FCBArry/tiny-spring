package aop;

import org.aopalliance.aop.Advice;

/**
 *
 * AspectJ
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor
{
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice)
    {
        this.advice = advice;
    }

    public void setExpression(String expression)
    {
        this.pointcut.setExpression(expression);
    }

	@Override
	public Advice getAdvice()
    {
		return advice;
	}

    @Override
	public Pointcut getPointcut()
    {
		return pointcut;
	}
}
