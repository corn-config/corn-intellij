package dev.jstanger.language;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import dev.jstanger.language.psi.*;
import com.intellij.openapi.vfs.VirtualFile;
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
     *
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

            if (includeAssignments) {
                CornAssignBlock assignBlock = PsiTreeUtil.getChildOfType(file, CornAssignBlock.class);

                if (assignBlock != null) {
                    CornAssignment[] values = PsiTreeUtil.getChildrenOfType(assignBlock, CornAssignment.class);

                    if (values != null) {
                        for (CornAssignment value : values) {
                            String inputName = value.getInputName();
                            if (name == null || (inputName != null && inputName.equals(name))) {
                                result.add(value.getInput());
                            }
                        }
                    }
                }
            }

            CornObject topLevelObject = PsiTreeUtil.getChildOfType(file, CornObject.class);

            if (topLevelObject != null) {
                findObjectInputs(topLevelObject, name, result);
            }
        }

        return result;
    }

    /**
     * Recursively finds all input elements in an object.
     *
     * @param object
     * @param inputs
     */
    private static void findObjectInputs(CornObject object, @Nullable String name, ArrayList<CornInput> inputs) {
        List<CornPair> pairs = object.getPairList();

        for (CornPair pair : pairs) {
            CornValue value = pair.getValue();

            if (value == null) {
                return;
            }

            if (value.getInput() != null) {
                if (name == null || name.equals(value.getInput().getName()))
                    inputs.add(value.getInput());
            } else if (value.getObject() != null) {
                findObjectInputs(value.getObject(), name, inputs);
            } else if (value.getArray() != null) {
                findArrayInputs(value.getArray(), name, inputs);
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
        List<CornValue> values = array.getValueList();

        for (CornValue value : values) {
            if (value.getInput() != null) {
                if (name == null || name.equals(value.getInput().getName()))
                    inputs.add(value.getInput());
            } else if (value.getObject() != null) {
                findObjectInputs(value.getObject(), name, inputs);
            } else if (value.getArray() != null) {
                findArrayInputs(value.getArray(), name, inputs);
            }
        }
    }
}
