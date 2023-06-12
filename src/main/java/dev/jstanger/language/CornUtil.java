package dev.jstanger.language;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import dev.jstanger.language.psi.*;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CornUtil {
    /**
     * Finds all assignments in the current file.
     * <p>
     * FIXME: Should be able to get from whole project for symbol contributor
     *
     * @param project
     * @param input
     * @return
     */
    public static List<CornAssignment> findAssignments(Project project, @Nullable String input) {
        List<CornAssignment> result = new ArrayList<>();
        VirtualFile selectedFile = FileEditorManager.getInstance(project).getSelectedFiles()[0];

        if (selectedFile != null && selectedFile.getFileType() == CornFileType.INSTANCE) {
            CornFile file = (CornFile) PsiManager.getInstance(project).findFile(selectedFile);

            CornAssignBlock assignBlock = PsiTreeUtil.getChildOfType(file, CornAssignBlock.class);

            if (assignBlock == null) {
                return result;
            }

            CornAssignment[] values = PsiTreeUtil.getChildrenOfType(assignBlock, CornAssignment.class);

            if (values != null) {
                for (CornAssignment value : values) {
                    if (input == null || value.getInputName().equals(input)) {
                        result.add(value);
                    }
                }
            }

        }

        return result;
    }

    /**
     * Finds all paths in the current file.
     * <p>
     * FIXME: Should be able to get from whole project for symbol contributor
     *
     * @param project
     * @return
     */
    @Nullable
    public static List<CornPath> findPaths(Project project) {
        VirtualFile selectedFile = FileEditorManager.getInstance(project).getSelectedFiles()[0];

        if (selectedFile != null && selectedFile.getFileType() == CornFileType.INSTANCE) {
            CornFile file = (CornFile) PsiManager.getInstance(project).findFile(selectedFile);

            Collection<CornPath> paths = PsiTreeUtil.findChildrenOfType(file, CornPath.class);
            return new ArrayList<>(paths);
        }

        return null;
    }

    /**
     * Finds all inputs elements, regardless of location or validity, inside the current file.
     *
     * @param project
     * @param name
     * @return
     */
    public static List<CornInput> findInputs(Project project, @Nullable String name, boolean includeAssignments) {
        ArrayList<CornInput> result = new ArrayList<>();
        VirtualFile selectedFile = FileEditorManager.getInstance(project).getSelectedFiles()[0];

        if (selectedFile != null && selectedFile.getFileType() == CornFileType.INSTANCE) {
            CornFile file = (CornFile) PsiManager.getInstance(project).findFile(selectedFile);

            if (file != null && includeAssignments) {
                findAssignmentInputs(file, name, result);
            }

            CornObject topLevelObject = PsiTreeUtil.getChildOfType(file, CornObject.class);

            if (topLevelObject != null) {
                findObjectInputs(topLevelObject, name, result);
            }
        }

        return result;
    }

    /**
     * Recursively finds all input elements in an assignment block.
     *
     * @param file
     * @param name
     * @param inputs
     */
    private static void findAssignmentInputs(@NotNull CornFile file, @Nullable String name, @NotNull ArrayList<CornInput> inputs) {
        CornAssignBlock assignBlock = PsiTreeUtil.getChildOfType(file, CornAssignBlock.class);

        if (assignBlock != null) {
            CornAssignment[] values = PsiTreeUtil.getChildrenOfType(assignBlock, CornAssignment.class);

            if (values != null) {
                for (CornAssignment assignment : values) {
                    String inputName = assignment.getInputName();
                    if (name == null || (inputName != null && inputName.equals(name))) {
                        inputs.add(assignment.getInput());
                    }

                    CornValue value = assignment.getValue();
                    findValueInputs(value, name, inputs);
                }
            }
        }
    }

    /**
     * Recursively finds all input elements in an object.
     *
     * @param object
     * @param inputs
     */
    private static void findObjectInputs(CornObject object, @Nullable String name, ArrayList<CornInput> inputs) {
        List<CornObjectValue> objectValues = object.getObjectValueList();

        for (CornObjectValue objectValue : objectValues) {
            CornPair pair = objectValue.getPair();

            if (pair != null) {
                CornValue value = pair.getValue();
                findValueInputs(value, name, inputs);
            } else {
                var spread = objectValue.getSpread();
                if (spread == null) return;
                var input = spread.getInput();

                if (name == null || name.equals(input.getName())) inputs.add(input);
            }
        }
    }

    /**
     * Recursively finds all input elements in an array.
     *
     * @param array
     * @param inputs
     */
    private static void findArrayInputs(CornArray array, @Nullable String name, ArrayList<CornInput> inputs) {
        List<CornArrayValue> arrayValues = array.getArrayValueList();

        for (CornArrayValue arrayValue : arrayValues) {
            CornValue value = arrayValue.getValue();

            if (value != null) {
                findValueInputs(value, name, inputs);
            } else {
                var spread = arrayValue.getSpread();
                if (spread == null) return;
                var input = spread.getInput();

                if (name == null || name.equals(input.getName())) inputs.add(input);
            }

        }
    }

    /**
     * Recursively finds inputs inside in a value.
     *
     * @param value
     * @param name
     * @param inputs
     */
    private static void findValueInputs(CornValue value, @Nullable String name, ArrayList<CornInput> inputs) {
        if (value.getInput() != null) {
            var input = value.getInput();
            if (name == null || name.equals(input.getName())) inputs.add(input);
        } else if (value.getObject() != null) {
            findObjectInputs(value.getObject(), name, inputs);
        } else if (value.getArray() != null) {
            findArrayInputs(value.getArray(), name, inputs);
        }
    }
}
