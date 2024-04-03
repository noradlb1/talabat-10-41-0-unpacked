package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public class AnnotationRemapper extends AnnotationVisitor {

    /* renamed from: c  reason: collision with root package name */
    public final String f27416c;

    /* renamed from: d  reason: collision with root package name */
    public final Remapper f27417d;

    @Deprecated
    public AnnotationRemapper(AnnotationVisitor annotationVisitor, Remapper remapper) {
        this((String) null, annotationVisitor, remapper);
    }

    private String mapAnnotationAttributeName(String str) {
        String str2 = this.f27416c;
        if (str2 == null) {
            return str;
        }
        return this.f27417d.mapAnnotationAttributeName(str2, str);
    }

    public AnnotationVisitor a(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27346a, str, annotationVisitor, this.f27417d).c(b(annotationVisitor));
    }

    @Deprecated
    public AnnotationVisitor b(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27346a, (String) null, annotationVisitor, this.f27417d);
    }

    public final AnnotationVisitor c(AnnotationVisitor annotationVisitor) {
        if (annotationVisitor.getClass() == getClass()) {
            AnnotationRemapper annotationRemapper = (AnnotationRemapper) annotationVisitor;
            if (annotationRemapper.f27346a == this.f27346a && annotationRemapper.f27347b == this.f27347b && annotationRemapper.f27417d == this.f27417d) {
                return this;
            }
            return annotationVisitor;
        }
        return annotationVisitor;
    }

    public void visit(String str, Object obj) {
        super.visit(mapAnnotationAttributeName(str), this.f27417d.mapValue(obj));
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(mapAnnotationAttributeName(str), this.f27417d.mapDesc(str2));
        if (visitAnnotation == null) {
            return null;
        }
        if (visitAnnotation == this.f27347b) {
            return this;
        }
        return a(str2, visitAnnotation);
    }

    public AnnotationVisitor visitArray(String str) {
        AnnotationVisitor visitArray = super.visitArray(mapAnnotationAttributeName(str));
        if (visitArray == null) {
            return null;
        }
        if (visitArray == this.f27347b) {
            return this;
        }
        return a((String) null, visitArray);
    }

    public void visitEnum(String str, String str2, String str3) {
        super.visitEnum(mapAnnotationAttributeName(str), this.f27417d.mapDesc(str2), str3);
    }

    public AnnotationRemapper(String str, AnnotationVisitor annotationVisitor, Remapper remapper) {
        this(Opcodes.ASM9, str, annotationVisitor, remapper);
    }

    public AnnotationRemapper(int i11, String str, AnnotationVisitor annotationVisitor, Remapper remapper) {
        super(i11, annotationVisitor);
        this.f27416c = str;
        this.f27417d = remapper;
    }
}
