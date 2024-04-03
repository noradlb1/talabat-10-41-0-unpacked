package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

public abstract class MetadataAwareClassVisitor extends ClassVisitor {
    private boolean triggerAttributes = true;
    private boolean triggerNestHost = true;
    private boolean triggerOuterClass = true;

    public MetadataAwareClassVisitor(int i11, ClassVisitor classVisitor) {
        super(i11, classVisitor);
    }

    private void considerTriggerAfterAttributes() {
        if (this.triggerAttributes) {
            this.triggerAttributes = false;
            a();
        }
    }

    private void considerTriggerNestHost() {
        if (this.triggerNestHost) {
            this.triggerNestHost = false;
            b();
        }
    }

    private void considerTriggerOuterClass() {
        if (this.triggerOuterClass) {
            this.triggerOuterClass = false;
            c();
        }
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public AnnotationVisitor d(String str, boolean z11) {
        return super.visitAnnotation(str, z11);
    }

    public void e(Attribute attribute) {
        super.visitAttribute(attribute);
    }

    public void f() {
        super.visitEnd();
    }

    public FieldVisitor g(int i11, String str, String str2, String str3, Object obj) {
        return super.visitField(i11, str, str2, str3, obj);
    }

    public void h(String str, String str2, String str3, int i11) {
        super.visitInnerClass(str, str2, str3, i11);
    }

    public MethodVisitor i(int i11, String str, String str2, String str3, String[] strArr) {
        return super.visitMethod(i11, str, str2, str3, strArr);
    }

    public void j(String str) {
        super.visitNestHost(str);
    }

    public void k(String str) {
        super.visitNestMember(str);
    }

    public void l(String str, String str2, String str3) {
        super.visitOuterClass(str, str2, str3);
    }

    public void m(String str) {
        super.visitPermittedSubclass(str);
    }

    public RecordComponentVisitor n(String str, String str2, String str3) {
        return super.visitRecordComponent(str, str2, str3);
    }

    public AnnotationVisitor o(int i11, TypePath typePath, String str, boolean z11) {
        return super.visitTypeAnnotation(i11, typePath, str, z11);
    }

    public final AnnotationVisitor visitAnnotation(String str, boolean z11) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return d(str, z11);
    }

    public final void visitAttribute(Attribute attribute) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        e(attribute);
    }

    public final void visitEnd() {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        f();
    }

    public final FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return g(i11, str, str2, str3, obj);
    }

    public final void visitInnerClass(String str, String str2, String str3, int i11) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        h(str, str2, str3, i11);
    }

    public final MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return i(i11, str, str2, str3, strArr);
    }

    public final void visitNestHost(String str) {
        this.triggerNestHost = false;
        j(str);
    }

    public final void visitNestMember(String str) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        k(str);
    }

    public final void visitOuterClass(String str, String str2, String str3) {
        considerTriggerNestHost();
        this.triggerOuterClass = false;
        l(str, str2, str3);
    }

    public final void visitPermittedSubclass(String str) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        m(str);
    }

    public RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return n(str, str2, str3);
    }

    public final AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return o(i11, typePath, str, z11);
    }
}
