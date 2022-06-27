package data;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class DataCenter {
    /**
     * 选择的文本
    */
     public static String SELECTED_TEXT = null;
    /**
     * 当前的文件名称
     */
    public static String CURRENT_FILE_NAME = null;
    /**
     *  当前的文件类型
     */
    public static String CURRENT_FILE_TYPE = null;
    /**
     * 笔记列表集合,这里使用的是LinkedList,而不是ArrayList,是因为考虑到之后的笔记的顺序可能发生变化
     */
    public static List<NoteData> NOTELIST = new LinkedList<>();


    private static String[] HEAD ={"标题","备注", "文件名","代码段"};

    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null , HEAD);


    public static void reset() {
        NOTELIST.clear();
        TABLE_MODEL.setDataVector(null , HEAD);
    }
}