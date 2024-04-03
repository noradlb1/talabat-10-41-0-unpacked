package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.TypePath;

public class MethodRemapper extends MethodVisitor {

    /* renamed from: d  reason: collision with root package name */
    public final Remapper f27421d;

    public MethodRemapper(MethodVisitor methodVisitor, Remapper remapper) {
        this(Opcodes.ASM9, methodVisitor, remapper);
    }

    private Object[] remapFrameTypes(int i11, Object[] objArr) {
        if (objArr == null) {
            return objArr;
        }
        Object[] objArr2 = null;
        for (int i12 = 0; i12 < i11; i12++) {
            if (objArr[i12] instanceof String) {
                if (objArr2 == null) {
                    objArr2 = new Object[i11];
                    System.arraycopy(objArr, 0, objArr2, 0, i11);
                }
                objArr2[i12] = this.f27421d.mapType(objArr[i12]);
            }
        }
        if (objArr2 == null) {
            return objArr;
        }
        return objArr2;
    }

    public AnnotationVisitor a(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27399b, str, annotationVisitor, this.f27421d).c(b(annotationVisitor));
    }

    @Deprecated
    public AnnotationVisitor b(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27399b, (String) null, annotationVisitor, this.f27421d);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.f27421d.mapDesc(str), z11);
        if (visitAnnotation == null) {
            return visitAnnotation;
        }
        return a(str, visitAnnotation);
    }

    public AnnotationVisitor visitAnnotationDefault() {
        AnnotationVisitor visitAnnotationDefault = super.visitAnnotationDefault();
        if (visitAnnotationDefault == null) {
            return visitAnnotationDefault;
        }
        return a((String) null, visitAnnotationDefault);
    }

    public void visitFieldInsn(int i11, String str, String str2, String str3) {
        super.visitFieldInsn(i11, this.f27421d.mapType(str), this.f27421d.mapFieldName(str, str2, str3), this.f27421d.mapDesc(str3));
    }

    public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        super.visitFrame(i11, i12, remapFrameTypes(i12, objArr), i13, remapFrameTypes(i13, objArr2));
    }

    public AnnotationVisitor visitInsnAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        AnnotationVisitor visitInsnAnnotation = super.visitInsnAnnotation(i11, typePath, this.f27421d.mapDesc(str), z11);
        if (visitInsnAnnotation == null) {
            return visitInsnAnnotation;
        }
        return a(str, visitInsnAnnotation);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        Object[] objArr2 = new Object[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            objArr2[i11] = this.f27421d.mapValue(objArr[i11]);
        }
        super.visitInvokeDynamicInsn(this.f27421d.mapInvokeDynamicMethodName(str, str2), this.f27421d.mapMethodDesc(str2), (Handle) this.f27421d.mapValue(handle), objArr2);
    }

    public void visitLdcInsn(Object obj) {
        super.visitLdcInsn(this.f27421d.mapValue(obj));
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i11) {
        super.visitLocalVariable(str, this.f27421d.mapDesc(str2), this.f27421d.mapSignature(str3, true), label, label2, i11);
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i11, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z11) {
        String str2 = str;
        AnnotationVisitor visitLocalVariableAnnotation = super.visitLocalVariableAnnotation(i11, typePath, labelArr, labelArr2, iArr, this.f27421d.mapDesc(str2), z11);
        if (visitLocalVariableAnnotation == null) {
            return visitLocalVariableAnnotation;
        }
        return a(str2, visitLocalVariableAnnotation);
    }

    public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
        if (this.f27399b >= 327680 || (i11 & 256) != 0) {
            super.visitMethodInsn(i11, this.f27421d.mapType(str), this.f27421d.mapMethodName(str, str2, str3), this.f27421d.mapMethodDesc(str3), z11);
            return;
        }
        super.visitMethodInsn(i11, str, str2, str3, z11);
    }

    public void visitMultiANewArrayInsn(String str, int i11) {
        super.visitMultiANewArrayInsn(this.f27421d.mapDesc(str), i11);
    }

    public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
        AnnotationVisitor visitParameterAnnotation = super.visitParameterAnnotation(i11, this.f27421d.mapDesc(str), z11);
        if (visitParameterAnnotation == null) {
            return visitParameterAnnotation;
        }
        return a(str, visitParameterAnnotation);
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        AnnotationVisitor visitTryCatchAnnotation = super.visitTryCatchAnnotation(i11, typePath, this.f27421d.mapDesc(str), z11);
        if (visitTryCatchAnnotation == null) {
            return visitTryCatchAnnotation;
        }
        return a(str, visitTryCatchAnnotation);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        super.visitTryCatchBlock(label, label2, label3, str == null ? null : this.f27421d.mapType(str));
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i11, typePath, this.f27421d.mapDesc(str), z11);
        if (visitTypeAnnotation == null) {
            return visitTypeAnnotation;
        }
        return a(str, visitTypeAnnotation);
    }

    public void visitTypeInsn(int i11, String str) {
        super.visitTypeInsn(i11, this.f27421d.mapType(str));
    }

    public MethodRemapper(int i11, MethodVisitor methodVisitor, Remapper remapper) {
        super(i11, methodVisitor);
        this.f27421d = remapper;
    }
}
