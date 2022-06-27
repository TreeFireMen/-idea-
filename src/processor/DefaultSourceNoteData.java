package processor;

import java.util.List;

import data.NoteData;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class DefaultSourceNoteData implements SourceNoteData{

    private String fileName;
    private String topic;
    private List<NoteData> noteList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }
}
