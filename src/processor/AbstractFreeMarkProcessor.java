package processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public abstract class AbstractFreeMarkProcessor implements Process{

    protected abstract Object getModel(SourceNoteData sourceNoteData);

    /**
        模板这里导入了FreeMarker包
     */
    protected abstract Template getTemplate() throws IOException;

    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws Exception;


    /**
     * 模板设计模式: 只希望子类去实现上面的抽象方法,实现之后调用process就像按照模板一样执行方法process
     * 不希望子类去重写process方法,所以加上了final
     * @param sourceNoteData
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public final void process(SourceNoteData sourceNoteData) throws Exception {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        template.process(model, writer);
    }
}
