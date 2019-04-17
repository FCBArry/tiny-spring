package beans;

/**
 *
 * test测试
 *
 * @author 科兴第一盖伦
 * @version 2019/4/16
 */
public class HelloWorldServiceImpl implements HelloWorldService
{
    private String text;

    private OutputService outputService;

    @Override
    public void helloWorld()
    {
        outputService.output(text);
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setOutputService(OutputService outputService)
    {
        this.outputService = outputService;
    }
}
