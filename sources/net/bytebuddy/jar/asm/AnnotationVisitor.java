package net.bytebuddy.jar.asm;

public abstract class AnnotationVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final int f27346a;

    /* renamed from: b  reason: collision with root package name */
    public AnnotationVisitor f27347b;

    public AnnotationVisitor(int i11) {
        this(i11, (AnnotationVisitor) null);
    }

    public void visit(String str, Object obj) {
        AnnotationVisitor annotationVisitor = this.f27347b;
        if (annotationVisitor != null) {
            annotationVisitor.visit(str, obj);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        AnnotationVisitor annotationVisitor = this.f27347b;
        if (annotationVisitor != null) {
            return annotationVisitor.visitAnnotation(str, str2);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String str) {
        AnnotationVisitor annotationVisitor = this.f27347b;
        if (annotationVisitor != null) {
            return annotationVisitor.visitArray(str);
        }
        return null;
    }

    public void visitEnd() {
        AnnotationVisitor annotationVisitor = this.f27347b;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        AnnotationVisitor annotationVisitor = this.f27347b;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnum(str, str2, str3);
        }
    }

    public AnnotationVisitor(int i11, AnnotationVisitor annotationVisitor) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            if (i11 == 17432576) {
                Constants.a(this);
            }
            this.f27346a = i11;
            this.f27347b = annotationVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }
}
