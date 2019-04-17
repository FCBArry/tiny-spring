package beans;

/**
 *
 * test测试
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class OutputServiceImpl implements OutputService
{
    private HelloWorldService helloWorldService;

    @Override
    public void output(String text)
    {
        System.out.println(text);
    }
}
