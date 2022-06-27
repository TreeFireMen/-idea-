package processor;

import java.util.List;

import com.intellij.openapi.graph.layout.hierarchic.incremental.NodeData;
import data.NoteData;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public interface SourceNoteData {
    String getFileName();

    String getTopic();

    List<NoteData> getNoteList();

}
