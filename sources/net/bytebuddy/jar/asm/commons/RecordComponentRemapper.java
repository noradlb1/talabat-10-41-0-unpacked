package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

public class RecordComponentRemapper extends RecordComponentVisitor {

    /* renamed from: c  reason: collision with root package name */
    public final Remapper f27423c;

    public RecordComponentRemapper(RecordComponentVisitor recordComponentVisitor, Remapper remapper) {
        this(Opcodes.ASM9, recordComponentVisitor, remapper);
    }

    public AnnotationVisitor a(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27404a, str, annotationVisitor, this.f27423c).c(b(annotationVisitor));
    }

    @Deprecated
    public AnnotationVisitor b(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27404a, (String) null, annotationVisitor, this.f27423c);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.f27423c.mapDesc(str), z11);
        if (visitAnnotation == null) {
            return null;
        }
        return a(str, visitAnnotation);
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i11, typePath, this.f27423c.mapDesc(str), z11);
        if (visitTypeAnnotation == null) {
            return null;
        }
        return a(str, visitTypeAnnotation);
    }

    public RecordComponentRemapper(int i11, RecordComponentVisitor recordComponentVisitor, Remapper remapper) {
        super(i11, recordComponentVisitor);
        this.f27423c = remapper;
    }
}
