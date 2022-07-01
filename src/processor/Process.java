package processor;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public interface Process {
    void process(SourceNoteData sourceNoteData) throws Exception;
}
