package processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import data.NoteData;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/29
 */
public class ExcelProcessor extends AbstractExcelProcessor{

    @Override
    protected Map<String, String> getHeader(SourceNoteData sourceNoteData) {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("title","笔记标题");
        map.put("content","笔记内容");
        map.put("file","文件位置");
        map.put("mark","标记笔记内容");
        return map;
    }

    @Override
    protected  Collection<Map<String,String>> getContent(SourceNoteData sourceNoteData) {
        List<Map<String,String>> list = new ArrayList<>();
        List<NoteData> noteList = sourceNoteData.getNoteList();
        noteList.forEach(l -> {
            Map<String,String> map = new LinkedHashMap<>();
            map.put("title", l.getTitle());
            map.put("content", l.getContent());
            map.put("file", l.getFileName());
            map.put("mark", l.getMark());
            list.add(map);
        });
        return list;
    }
}
