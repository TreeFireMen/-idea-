package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import data.DataCenter;
import org.apache.commons.lang3.ObjectUtils;
import processor.DefaultSourceNoteData;
import processor.ExcelProcessor;
import processor.MDFreemarkProcessor;
import processor.Process;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbContent;
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JPanel contentPanel;
    private JButton btnExcel;

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        // 为三个按钮创建点击事件
        btnCreate.addActionListener(e ->{
            String topic = tfTopic.getText();
            String fileName = topic + ".md";
            if (ObjectUtils.isEmpty(topic)) {
                MessageDialogBuilder.yesNo("无效操作", "文档标题没有输入");
                return;
            }
            VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getBaseDir());
            if (virtualFile != null){
                String path = virtualFile.getPath();
                String fullPath = path + "/" + fileName;
                Process process = new MDFreemarkProcessor();
                try {
                    process.process(new DefaultSourceNoteData(fullPath, topic, DataCenter.NOTELIST));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }

        });
        btnClear.addActionListener(e -> DataCenter.reset());
        btnClose.addActionListener(e -> toolWindow.hide(null));

        btnExcel.addActionListener(e -> {
            String topic = tfTopic.getText();
            if (ObjectUtils.isEmpty(topic)) {
                MessageDialogBuilder.yesNo("无效操作", "文档标题没有输入");
                return;
            }
            Process process = new ExcelProcessor();
            try {
                process.process(new DefaultSourceNoteData("excelMark", topic, DataCenter.NOTELIST));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void init() {
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
