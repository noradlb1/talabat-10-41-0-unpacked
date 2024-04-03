package net.bytebuddy.jar.asm.commons;

import java.util.List;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

public class ClassRemapper extends ClassVisitor {

    /* renamed from: d  reason: collision with root package name */
    public final Remapper f27418d;

    /* renamed from: e  reason: collision with root package name */
    public String f27419e;

    public ClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
        this(Opcodes.ASM9, classVisitor, remapper);
    }

    public AnnotationVisitor a(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27353b, str, annotationVisitor, this.f27418d).c(b(annotationVisitor));
    }

    @Deprecated
    public AnnotationVisitor b(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.f27353b, (String) null, annotationVisitor, this.f27418d);
    }

    public FieldVisitor c(FieldVisitor fieldVisitor) {
        return new FieldRemapper(this.f27353b, fieldVisitor, this.f27418d);
    }

    public MethodVisitor d(MethodVisitor methodVisitor) {
        return new MethodRemapper(this.f27353b, methodVisitor, this.f27418d);
    }

    public ModuleVisitor e(ModuleVisitor moduleVisitor) {
        return new ModuleRemapper(this.f27353b, moduleVisitor, this.f27418d);
    }

    public RecordComponentVisitor f(RecordComponentVisitor recordComponentVisitor) {
        return new RecordComponentRemapper(this.f27353b, recordComponentVisitor, this.f27418d);
    }

    public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        String[] strArr2;
        this.f27419e = str;
        String mapType = this.f27418d.mapType(str);
        String mapSignature = this.f27418d.mapSignature(str2, false);
        String mapType2 = this.f27418d.mapType(str3);
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = this.f27418d.mapTypes(strArr);
        }
        super.visit(i11, i12, mapType, mapSignature, mapType2, strArr2);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.f27418d.mapDesc(str), z11);
        if (visitAnnotation == null) {
            return null;
        }
        return a(str, visitAnnotation);
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute instanceof ModuleHashesAttribute) {
            List<String> list = ((ModuleHashesAttribute) attribute).modules;
            for (int i11 = 0; i11 < list.size(); i11++) {
                list.set(i11, this.f27418d.mapModuleName(list.get(i11)));
            }
        }
        super.visitAttribute(attribute);
    }

    public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
        Object obj2;
        String mapFieldName = this.f27418d.mapFieldName(this.f27419e, str, str2);
        String mapDesc = this.f27418d.mapDesc(str2);
        String mapSignature = this.f27418d.mapSignature(str3, true);
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = this.f27418d.mapValue(obj);
        }
        FieldVisitor visitField = super.visitField(i11, mapFieldName, mapDesc, mapSignature, obj2);
        if (visitField == null) {
            return null;
        }
        return c(visitField);
    }

    public void visitInnerClass(String str, String str2, String str3, int i11) {
        String str4;
        String mapType = this.f27418d.mapType(str);
        String str5 = null;
        if (str2 == null) {
            str4 = null;
        } else {
            str4 = this.f27418d.mapType(str2);
        }
        if (str3 != null) {
            str5 = this.f27418d.mapInnerClassName(str, str2, str3);
        }
        super.visitInnerClass(mapType, str4, str5, i11);
    }

    public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
        String[] strArr2;
        String mapMethodDesc = this.f27418d.mapMethodDesc(str2);
        String mapMethodName = this.f27418d.mapMethodName(this.f27419e, str, str2);
        String mapSignature = this.f27418d.mapSignature(str3, false);
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = this.f27418d.mapTypes(strArr);
        }
        MethodVisitor visitMethod = super.visitMethod(i11, mapMethodName, mapMethodDesc, mapSignature, strArr2);
        if (visitMethod == null) {
            return null;
        }
        return d(visitMethod);
    }

    public ModuleVisitor visitModule(String str, int i11, String str2) {
        ModuleVisitor visitModule = super.visitModule(this.f27418d.mapModuleName(str), i11, str2);
        if (visitModule == null) {
            return null;
        }
        return e(visitModule);
    }

    public void visitNestHost(String str) {
        super.visitNestHost(this.f27418d.mapType(str));
    }

    public void visitNestMember(String str) {
        super.visitNestMember(this.f27418d.mapType(str));
    }

    public void visitOuterClass(String str, String str2, String str3) {
        String str4;
        String mapType = this.f27418d.mapType(str);
        String str5 = null;
        if (str2 == null) {
            str4 = null;
        } else {
            str4 = this.f27418d.mapMethodName(str, str2, str3);
        }
        if (str3 != null) {
            str5 = this.f27418d.mapMethodDesc(str3);
        }
        super.visitOuterClass(mapType, str4, str5);
    }

    public void visitPermittedSubclass(String str) {
        super.visitPermittedSubclass(this.f27418d.mapType(str));
    }

    public RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        RecordComponentVisitor visitRecordComponent = super.visitRecordComponent(this.f27418d.mapRecordComponentName(this.f27419e, str, str2), this.f27418d.mapDesc(str2), this.f27418d.mapSignature(str3, true));
        if (visitRecordComponent == null) {
            return null;
        }
        return f(visitRecordComponent);
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i11, typePath, this.f27418d.mapDesc(str), z11);
        if (visitTypeAnnotation == null) {
            return null;
        }
        return a(str, visitTypeAnnotation);
    }

    public ClassRemapper(int i11, ClassVisitor classVisitor, Remapper remapper) {
        super(i11, classVisitor);
        this.f27418d = remapper;
    }
}
