package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;

public abstract class ExceptionTableSensitiveMethodVisitor extends MethodVisitor {
    private boolean trigger = true;

    public ExceptionTableSensitiveMethodVisitor(int i11, MethodVisitor methodVisitor) {
        super(i11, methodVisitor);
    }

    private void considerEndOfExceptionTable() {
        if (this.trigger) {
            this.trigger = false;
            a();
        }
    }

    public abstract void a();

    public void b(int i11, String str, String str2, String str3) {
        super.visitFieldInsn(i11, str, str2, str3);
    }

    public void c(int i11, int i12) {
        super.visitIincInsn(i11, i12);
    }

    public void d(int i11) {
        super.visitInsn(i11);
    }

    public void e(int i11, int i12) {
        super.visitIntInsn(i11, i12);
    }

    public void f(String str, String str2, Handle handle, Object... objArr) {
        super.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    public void g(int i11, Label label) {
        super.visitJumpInsn(i11, label);
    }

    public void h(Label label) {
        super.visitLabel(label);
    }

    public void i(Object obj) {
        super.visitLdcInsn(obj);
    }

    public void j(Label label, int[] iArr, Label[] labelArr) {
        super.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    @Deprecated
    public void k(int i11, String str, String str2, String str3) {
        super.visitMethodInsn(i11, str, str2, str3);
    }

    public void l(int i11, String str, String str2, String str3, boolean z11) {
        super.visitMethodInsn(i11, str, str2, str3, z11);
    }

    public void m(String str, int i11) {
        super.visitMultiANewArrayInsn(str, i11);
    }

    public void n(int i11, int i12, Label label, Label... labelArr) {
        super.visitTableSwitchInsn(i11, i12, label, labelArr);
    }

    public void o(int i11, String str) {
        super.visitTypeInsn(i11, str);
    }

    public void onVisitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        super.visitFrame(i11, i12, objArr, i13, objArr2);
    }

    public void p(int i11, int i12) {
        super.visitVarInsn(i11, i12);
    }

    public final void visitFieldInsn(int i11, String str, String str2, String str3) {
        considerEndOfExceptionTable();
        b(i11, str, str2, str3);
    }

    public final void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        considerEndOfExceptionTable();
        onVisitFrame(i11, i12, objArr, i13, objArr2);
    }

    public final void visitIincInsn(int i11, int i12) {
        considerEndOfExceptionTable();
        c(i11, i12);
    }

    public final void visitInsn(int i11) {
        considerEndOfExceptionTable();
        d(i11);
    }

    public final void visitIntInsn(int i11, int i12) {
        considerEndOfExceptionTable();
        e(i11, i12);
    }

    public final void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        considerEndOfExceptionTable();
        f(str, str2, handle, objArr);
    }

    public final void visitJumpInsn(int i11, Label label) {
        considerEndOfExceptionTable();
        g(i11, label);
    }

    public final void visitLabel(Label label) {
        considerEndOfExceptionTable();
        h(label);
    }

    public final void visitLdcInsn(Object obj) {
        considerEndOfExceptionTable();
        i(obj);
    }

    public final void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        considerEndOfExceptionTable();
        j(label, iArr, labelArr);
    }

    public final void visitMethodInsn(int i11, String str, String str2, String str3) {
        considerEndOfExceptionTable();
        k(i11, str, str2, str3);
    }

    public final void visitMultiANewArrayInsn(String str, int i11) {
        considerEndOfExceptionTable();
        m(str, i11);
    }

    public final void visitTableSwitchInsn(int i11, int i12, Label label, Label... labelArr) {
        considerEndOfExceptionTable();
        n(i11, i12, label, labelArr);
    }

    public final void visitTypeInsn(int i11, String str) {
        considerEndOfExceptionTable();
        o(i11, str);
    }

    public final void visitVarInsn(int i11, int i12) {
        considerEndOfExceptionTable();
        p(i11, i12);
    }

    public final void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
        considerEndOfExceptionTable();
        l(i11, str, str2, str3, z11);
    }
}
