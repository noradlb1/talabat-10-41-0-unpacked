package net.bytebuddy.jar.asm;

public abstract class FieldVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final int f27378a;

    /* renamed from: b  reason: collision with root package name */
    public FieldVisitor f27379b;

    public FieldVisitor(int i11) {
        this(i11, (FieldVisitor) null);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        FieldVisitor fieldVisitor = this.f27379b;
        if (fieldVisitor != null) {
            return fieldVisitor.visitAnnotation(str, z11);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        FieldVisitor fieldVisitor = this.f27379b;
        if (fieldVisitor != null) {
            fieldVisitor.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        FieldVisitor fieldVisitor = this.f27379b;
        if (fieldVisitor != null) {
            fieldVisitor.visitEnd();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (this.f27378a >= 327680) {
            FieldVisitor fieldVisitor = this.f27379b;
            if (fieldVisitor != null) {
                return fieldVisitor.visitTypeAnnotation(i11, typePath, str, z11);
            }
            return null;
        }
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public FieldVisitor(int i11, FieldVisitor fieldVisitor) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            if (i11 == 17432576) {
                Constants.a(this);
            }
            this.f27378a = i11;
            this.f27379b = fieldVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }
}
