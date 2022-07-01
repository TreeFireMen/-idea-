package processor;

import java.util.Collection;
import java.util.Map;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/29
 */
public abstract class AbstractExcelProcessor implements Process {

    // 构建头部Map

    protected abstract Map<String, String> getHeader(SourceNoteData sourceNoteData);

    // 获取内容

    protected abstract Collection<Map<String, String>> getContent(SourceNoteData sourceNoteData);


    @Override
    public void process(SourceNoteData sourceNoteData) {
        Map<String, String> header = getHeader(sourceNoteData);
        Collection<Map<String, String>> content = getContent(sourceNoteData);
        // 调取生成Excel方法
        ExcelFuncImpl excelFunc = new ExcelFuncImpl();
        excelFunc.process(header, content);
    }
}
