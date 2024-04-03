package net.bytebuddy.utility.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.OpenedClassReader;

public class FramePaddingMethodVisitor extends MethodVisitor {
    private boolean injected = false;
    private final List<Label> labels = new ArrayList();
    private final Map<Label, Label> mapped = new HashMap();
    private boolean padding = false;

    public FramePaddingMethodVisitor(MethodVisitor methodVisitor) {
        super(OpenedClassReader.ASM_API, methodVisitor);
    }

    private void patch(int i11, Object[] objArr) {
        Label label;
        if (objArr != null) {
            for (int i12 = 0; i12 < i11; i12++) {
                Label label2 = objArr[i12];
                if ((label2 instanceof Label) && (label = this.mapped.get(label2)) != null) {
                    objArr[i12] = label;
                }
            }
        }
    }

    private void reset() {
        if (this.padding) {
            if (this.injected) {
                for (Label put : this.labels) {
                    Label label = new Label();
                    super.visitLabel(label);
                    this.mapped.put(put, label);
                }
                this.injected = false;
            }
            this.padding = false;
        }
        this.labels.clear();
    }

    public void visitFieldInsn(int i11, String str, String str2, String str3) {
        reset();
        super.visitFieldInsn(i11, str, str2, str3);
    }

    public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        if (this.padding) {
            this.injected = true;
            super.visitInsn(0);
        } else {
            this.padding = true;
        }
        if (!this.mapped.isEmpty()) {
            patch(i12, objArr);
            patch(i13, objArr2);
        }
        super.visitFrame(i11, i12, objArr, i13, objArr2);
    }

    public void visitIincInsn(int i11, int i12) {
        reset();
        super.visitIincInsn(i11, i12);
    }

    public void visitInsn(int i11) {
        reset();
        super.visitInsn(i11);
    }

    public void visitIntInsn(int i11, int i12) {
        reset();
        super.visitIntInsn(i11, i12);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        reset();
        super.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    public void visitJumpInsn(int i11, Label label) {
        reset();
        super.visitJumpInsn(i11, label);
    }

    public void visitLabel(Label label) {
        this.labels.add(label);
        super.visitLabel(label);
    }

    public void visitLdcInsn(Object obj) {
        reset();
        super.visitLdcInsn(obj);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        reset();
        super.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    public void visitMethodInsn(int i11, String str, String str2, String str3) {
        reset();
        super.visitMethodInsn(i11, str, str2, str3);
    }

    public void visitMultiANewArrayInsn(String str, int i11) {
        reset();
        super.visitMultiANewArrayInsn(str, i11);
    }

    public void visitTableSwitchInsn(int i11, int i12, Label label, Label... labelArr) {
        reset();
        super.visitTableSwitchInsn(i11, i12, label, labelArr);
    }

    public void visitTypeInsn(int i11, String str) {
        reset();
        super.visitTypeInsn(i11, str);
    }

    public void visitVarInsn(int i11, int i12) {
        reset();
        super.visitVarInsn(i11, i12);
    }

    public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
        reset();
        super.visitMethodInsn(i11, str, str2, str3, z11);
    }
}
