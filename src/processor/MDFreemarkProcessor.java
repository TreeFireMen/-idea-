package processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;


import com.intellij.ide.fileTemplates.impl.UrlUtil;
import data.NoteData;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class MDFreemarkProcessor extends AbstractFreeMarkProcessor {

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        HashMap map = new HashMap<>();
        String topic = sourceNoteData.getTopic();
        List<NoteData> noteList = sourceNoteData.getNoteList();
        map.put("topic", topic);
        map.put("noteList", noteList);
        return map;
    }

    @Override
    protected Template getTemplate() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        String templateContent = UrlUtil.loadText(MDFreemarkProcessor.class.getResource("/template/md.ftl"));
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("MDTemplate", templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);
        return configuration.getTemplate("MDTemplate");
    }

    /**
     * 保存的位置
     */
    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) throws Exception {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
    }
}
