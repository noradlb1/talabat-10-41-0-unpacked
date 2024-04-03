package net.bytebuddy.jar.asm;

public abstract class ClassVisitor {

    /* renamed from: b  reason: collision with root package name */
    public final int f27353b;

    /* renamed from: c  reason: collision with root package name */
    public ClassVisitor f27354c;

    public ClassVisitor(int i11) {
        this(i11, (ClassVisitor) null);
    }

    public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        if (this.f27353b >= 524288 || (65536 & i12) == 0) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                classVisitor.visit(i11, i12, str, str2, str3, strArr);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Records requires ASM8");
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            return classVisitor.visitAnnotation(str, z11);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            classVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            classVisitor.visitEnd();
        }
    }

    public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            return classVisitor.visitField(i11, str, str2, str3, obj);
        }
        return null;
    }

    public void visitInnerClass(String str, String str2, String str3, int i11) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            classVisitor.visitInnerClass(str, str2, str3, i11);
        }
    }

    public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            return classVisitor.visitMethod(i11, str, str2, str3, strArr);
        }
        return null;
    }

    public ModuleVisitor visitModule(String str, int i11, String str2) {
        if (this.f27353b >= 393216) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                return classVisitor.visitModule(str, i11, str2);
            }
            return null;
        }
        throw new UnsupportedOperationException("Module requires ASM6");
    }

    public void visitNestHost(String str) {
        if (this.f27353b >= 458752) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                classVisitor.visitNestHost(str);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("NestHost requires ASM7");
    }

    public void visitNestMember(String str) {
        if (this.f27353b >= 458752) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                classVisitor.visitNestMember(str);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("NestMember requires ASM7");
    }

    public void visitOuterClass(String str, String str2, String str3) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            classVisitor.visitOuterClass(str, str2, str3);
        }
    }

    public void visitPermittedSubclass(String str) {
        if (this.f27353b >= 589824) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                classVisitor.visitPermittedSubclass(str);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
    }

    public RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        if (this.f27353b >= 524288) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                return classVisitor.visitRecordComponent(str, str2, str3);
            }
            return null;
        }
        throw new UnsupportedOperationException("Record requires ASM8");
    }

    public void visitSource(String str, String str2) {
        ClassVisitor classVisitor = this.f27354c;
        if (classVisitor != null) {
            classVisitor.visitSource(str, str2);
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (this.f27353b >= 327680) {
            ClassVisitor classVisitor = this.f27354c;
            if (classVisitor != null) {
                return classVisitor.visitTypeAnnotation(i11, typePath, str, z11);
            }
            return null;
        }
        throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
    }

    public ClassVisitor(int i11, ClassVisitor classVisitor) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            if (i11 == 17432576) {
                Constants.a(this);
            }
            this.f27353b = i11;
            this.f27354c = classVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }
}
