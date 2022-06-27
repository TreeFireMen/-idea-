package dialog;

import java.awt.*;
import javax.swing.*;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import data.DataCenter;
import data.DataConvert;
import data.NoteData;
import org.jetbrains.annotations.Nullable;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class AddNoteDialog extends DialogWrapper {
    /**
     * 标题输入框
     */
    private EditorTextField etfTitle;
    /**
     * 内容输入框
     */
    private EditorTextField etfMark;

    public AddNoteDialog() {
        super(true);
        init();
        setTitle("添加笔记注释");
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        // 边界布局,容器划分为东西南北中五个区域,每个区域只能放一个组件
        JPanel panel = new JPanel(new BorderLayout());
        etfTitle = new EditorTextField("笔记标题");
        etfMark = new EditorTextField("笔记内容");
        // 设置框框的大小
        etfMark.setPreferredSize(new Dimension(200,100));
        panel.add(etfTitle, BorderLayout.NORTH);
        panel.add(etfMark, BorderLayout.CENTER);
        return panel;
    }

    /**
     * 添加按钮
     */
    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("添加到笔记列表");
        //按钮点击事件处理
        btnAdd.addActionListener(e -> {
            //获取标题
            String title = etfTitle.getText();
            //获取内容
            String mark = etfMark.getText();
            // 文件类型是在文件名称中存在的,对字符串做处理即可
            String fileType = DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark,
                    DataCenter.SELECTED_TEXT, DataCenter.CURRENT_FILE_NAME, fileType);
            DataCenter.NOTELIST.add(noteData);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
        });
        panel.add(btnAdd);
        return panel;
    }
}
