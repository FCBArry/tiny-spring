package aop;

/**
 *
 * Advice
 *
 * @author 科兴第一盖伦
 * @version 2019/4/17
 */
public interface PointcutAdvisor extends Advisor
{
   Pointcut getPointcut();
}
