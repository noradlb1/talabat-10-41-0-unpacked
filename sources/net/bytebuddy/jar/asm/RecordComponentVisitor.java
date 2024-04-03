package net.bytebuddy.jar.asm;

public abstract class RecordComponentVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final int f27404a;

    /* renamed from: b  reason: collision with root package name */
    public RecordComponentVisitor f27405b;

    public RecordComponentVisitor(int i11) {
        this(i11, (RecordComponentVisitor) null);
    }

    public RecordComponentVisitor getDelegate() {
        return this.f27405b;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        RecordComponentVisitor recordComponentVisitor = this.f27405b;
        if (recordComponentVisitor != null) {
            return recordComponentVisitor.visitAnnotation(str, z11);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        RecordComponentVisitor recordComponentVisitor = this.f27405b;
        if (recordComponentVisitor != null) {
            recordComponentVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        RecordComponentVisitor recordComponentVisitor = this.f27405b;
        if (recordComponentVisitor != null) {
            recordComponentVisitor.visitEnd();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        RecordComponentVisitor recordComponentVisitor = this.f27405b;
        if (recordComponentVisitor != null) {
            return recordComponentVisitor.visitTypeAnnotation(i11, typePath, str, z11);
        }
        return null;
    }

    public RecordComponentVisitor(int i11, RecordComponentVisitor recordComponentVisitor) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            if (i11 == 17432576) {
                Constants.a(this);
            }
            this.f27404a = i11;
            this.f27405b = recordComponentVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }
}
