package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.TypePath;

public class FieldRemapper extends FieldVisitor {

    /* renamed from: c  reason: collision with root package name */
    public final Remapper f27420c;

    public FieldRemapper(FieldVisitor fieldVisitor, Remapper remapper) {
        this(Opcodes.ASM9, fieldVisitor, remapper);
    }

    public AnnotationVisitor a(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27378a, str, annotationVisitor, this.f27420c).c(b(annotationVisitor));
    }

    @Deprecated
    public AnnotationVisitor b(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27378a, (String) null, annotationVisitor, this.f27420c);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.f27420c.mapDesc(str), z11);
        if (visitAnnotation == null) {
            return null;
        }
        return a(str, visitAnnotation);
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i11, typePath, this.f27420c.mapDesc(str), z11);
        if (visitTypeAnnotation == null) {
            return null;
        }
        return a(str, visitTypeAnnotation);
    }

    public FieldRemapper(int i11, FieldVisitor fieldVisitor, Remapper remapper) {
        super(i11, fieldVisitor);
        this.f27420c = remapper;
    }
}
