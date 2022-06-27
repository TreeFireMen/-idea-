package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import data.DataCenter;
import dialog.AddNoteDialog;

/**
 * @author zijian.zeng@hand-china.com
 * @since 2022/6/27
 */
public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 获取当前编辑器的对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        // 获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        // 获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();
        // 获取用户点击的文件名称(用户点击笔记的文件名称)
        String name = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        // 赋值给全局变量
        DataCenter.SELECTED_TEXT = selectedText;
        DataCenter.CURRENT_FILE_NAME = name;

        AddNoteDialog noteDialog = new AddNoteDialog();
        noteDialog.show();
    }
}
