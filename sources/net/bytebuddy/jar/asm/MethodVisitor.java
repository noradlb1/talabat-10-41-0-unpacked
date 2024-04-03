package net.bytebuddy.jar.asm;

public abstract class MethodVisitor {
    private static final String REQUIRES_ASM5 = "This feature requires ASM5";

    /* renamed from: b  reason: collision with root package name */
    public final int f27399b;

    /* renamed from: c  reason: collision with root package name */
    public MethodVisitor f27400c;

    public MethodVisitor(int i11) {
        this(i11, (MethodVisitor) null);
    }

    public void visitAnnotableParameterCount(int i11, boolean z11) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitAnnotableParameterCount(i11, z11);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            return methodVisitor.visitAnnotation(str, z11);
        }
        return null;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            return methodVisitor.visitAnnotationDefault();
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitAttribute(attribute);
        }
    }

    public void visitCode() {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitCode();
        }
    }

    public void visitEnd() {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitEnd();
        }
    }

    public void visitFieldInsn(int i11, String str, String str2, String str3) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitFieldInsn(i11, str, str2, str3);
        }
    }

    public void visitFrame(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitFrame(i11, i12, objArr, i13, objArr2);
        }
    }

    public void visitIincInsn(int i11, int i12) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitIincInsn(i11, i12);
        }
    }

    public void visitInsn(int i11) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitInsn(i11);
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (this.f27399b >= 327680) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                return methodVisitor.visitInsnAnnotation(i11, typePath, str, z11);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitIntInsn(int i11, int i12) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitIntInsn(i11, i12);
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        if (this.f27399b >= 327680) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                methodVisitor.visitInvokeDynamicInsn(str, str2, handle, objArr);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitJumpInsn(int i11, Label label) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitJumpInsn(i11, label);
        }
    }

    public void visitLabel(Label label) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitLabel(label);
        }
    }

    public void visitLdcInsn(Object obj) {
        if (this.f27399b < 327680 && ((obj instanceof Handle) || ((obj instanceof Type) && ((Type) obj).getSort() == 11))) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        } else if (this.f27399b >= 458752 || !(obj instanceof ConstantDynamic)) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                methodVisitor.visitLdcInsn(obj);
            }
        } else {
            throw new UnsupportedOperationException("This feature requires ASM7");
        }
    }

    public void visitLineNumber(int i11, Label label) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitLineNumber(i11, label);
        }
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i11) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i11);
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i11, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z11) {
        if (this.f27399b >= 327680) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                return methodVisitor.visitLocalVariableAnnotation(i11, typePath, labelArr, labelArr2, iArr, str, z11);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitLookupSwitchInsn(label, iArr, labelArr);
        }
    }

    public void visitMaxs(int i11, int i12) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitMaxs(i11, i12);
        }
    }

    @Deprecated
    public void visitMethodInsn(int i11, String str, String str2, String str3) {
        boolean z11 = false;
        int i12 = i11 | (this.f27399b < 327680 ? 256 : 0);
        if (i11 == 185) {
            z11 = true;
        }
        visitMethodInsn(i12, str, str2, str3, z11);
    }

    public void visitMultiANewArrayInsn(String str, int i11) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitMultiANewArrayInsn(str, i11);
        }
    }

    public void visitParameter(String str, int i11) {
        if (this.f27399b >= 327680) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                methodVisitor.visitParameter(str, i11);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            return methodVisitor.visitParameterAnnotation(i11, str, z11);
        }
        return null;
    }

    public void visitTableSwitchInsn(int i11, int i12, Label label, Label... labelArr) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitTableSwitchInsn(i11, i12, label, labelArr);
        }
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (this.f27399b >= 327680) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                return methodVisitor.visitTryCatchAnnotation(i11, typePath, str, z11);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitTryCatchBlock(label, label2, label3, str);
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (this.f27399b >= 327680) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                return methodVisitor.visitTypeAnnotation(i11, typePath, str, z11);
            }
            return null;
        }
        throw new UnsupportedOperationException(REQUIRES_ASM5);
    }

    public void visitTypeInsn(int i11, String str) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitTypeInsn(i11, str);
        }
    }

    public void visitVarInsn(int i11, int i12) {
        MethodVisitor methodVisitor = this.f27400c;
        if (methodVisitor != null) {
            methodVisitor.visitVarInsn(i11, i12);
        }
    }

    public MethodVisitor(int i11, MethodVisitor methodVisitor) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            if (i11 == 17432576) {
                Constants.a(this);
            }
            this.f27399b = i11;
            this.f27400c = methodVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }

    public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
        if (this.f27399b >= 327680 || (i11 & 256) != 0) {
            MethodVisitor methodVisitor = this.f27400c;
            if (methodVisitor != null) {
                methodVisitor.visitMethodInsn(i11 & -257, str, str2, str3, z11);
                return;
            }
            return;
        }
        if (z11 == (i11 == 185)) {
            visitMethodInsn(i11, str, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
    }
}
