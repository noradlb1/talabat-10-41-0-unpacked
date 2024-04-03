package net.bytebuddy.jar.asm;

import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.jar.asm.Attribute;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;

public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    private int accessFlags;
    private int compute;
    private ByteVector debugExtension;
    private int enclosingClassIndex;
    private int enclosingMethodIndex;
    private Attribute firstAttribute;
    private FieldWriter firstField;
    private MethodWriter firstMethod;
    private RecordComponentWriter firstRecordComponent;
    private ByteVector innerClasses;
    private int interfaceCount;
    private int[] interfaces;
    private FieldWriter lastField;
    private MethodWriter lastMethod;
    private RecordComponentWriter lastRecordComponent;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private ModuleWriter moduleWriter;
    private int nestHostClassIndex;
    private ByteVector nestMemberClasses;
    private int numberOfInnerClasses;
    private int numberOfNestMemberClasses;
    private int numberOfPermittedSubclasses;
    private ByteVector permittedSubclasses;
    private int signatureIndex;
    private int sourceFileIndex;
    private int superClass;
    private final SymbolTable symbolTable;
    private int thisClass;
    private int version;

    public ClassWriter(int i11) {
        this((ClassReader) null, i11);
    }

    private Attribute[] getAttributePrototypes() {
        Attribute.Set set = new Attribute.Set();
        set.a(this.firstAttribute);
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.f27379b) {
            fieldWriter.a(set);
        }
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.f27400c) {
            methodWriter.b(set);
        }
        for (RecordComponentWriter recordComponentWriter = this.firstRecordComponent; recordComponentWriter != null; recordComponentWriter = (RecordComponentWriter) recordComponentWriter.f27405b) {
            recordComponentWriter.a(set);
        }
        return set.b();
    }

    private byte[] replaceAsmInstructions(byte[] bArr, boolean z11) {
        int i11;
        Attribute[] attributePrototypes = getAttributePrototypes();
        this.firstField = null;
        this.lastField = null;
        this.firstMethod = null;
        this.lastMethod = null;
        this.lastRuntimeVisibleAnnotation = null;
        this.lastRuntimeInvisibleAnnotation = null;
        this.lastRuntimeVisibleTypeAnnotation = null;
        this.lastRuntimeInvisibleTypeAnnotation = null;
        this.moduleWriter = null;
        int i12 = 0;
        this.nestHostClassIndex = 0;
        this.numberOfNestMemberClasses = 0;
        this.nestMemberClasses = null;
        this.numberOfPermittedSubclasses = 0;
        this.permittedSubclasses = null;
        this.firstRecordComponent = null;
        this.lastRecordComponent = null;
        this.firstAttribute = null;
        if (z11) {
            i11 = 3;
        } else {
            i11 = 0;
        }
        this.compute = i11;
        ClassReader classReader = new ClassReader(bArr, 0, false);
        if (z11) {
            i12 = 8;
        }
        classReader.accept(this, attributePrototypes, i12 | 256);
        return toByteArray();
    }

    public ClassLoader a() {
        return getClass().getClassLoader();
    }

    public String b(String str, String str2) {
        ClassLoader a11 = a();
        try {
            Class cls = Class.forName(str.replace('/', '.'), false, a11);
            try {
                Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, a11);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace('.', '/');
            } catch (ClassNotFoundException e11) {
                throw new TypeNotPresentException(str2, e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new TypeNotPresentException(str, e12);
        }
    }

    public int newClass(String str) {
        return this.symbolTable.c(str).f27406a;
    }

    public int newConst(Object obj) {
        return this.symbolTable.b(obj).f27406a;
    }

    public int newConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        return this.symbolTable.e(str, str2, handle, objArr).f27406a;
    }

    public int newField(String str, String str2, String str3) {
        return this.symbolTable.f(str, str2, str3).f27406a;
    }

    @Deprecated
    public int newHandle(int i11, String str, String str2, String str3) {
        return newHandle(i11, str, str2, str3, i11 == 9);
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return this.symbolTable.i(str, str2, handle, objArr).f27406a;
    }

    public int newMethod(String str, String str2, String str3, boolean z11) {
        return this.symbolTable.m(str, str2, str3, z11).f27406a;
    }

    public int newMethodType(String str) {
        return this.symbolTable.l(str).f27406a;
    }

    public int newModule(String str) {
        return this.symbolTable.n(str).f27406a;
    }

    public int newNameType(String str, String str2) {
        return this.symbolTable.o(str, str2);
    }

    public int newPackage(String str) {
        return this.symbolTable.p(str).f27406a;
    }

    public int newUTF8(String str) {
        return this.symbolTable.r(str);
    }

    public byte[] toByteArray() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = (this.interfaceCount * 2) + 24;
        int i18 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.f27379b) {
            i18++;
            i17 += fieldWriter.b();
        }
        int i19 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.f27400c) {
            i19++;
            i17 += methodWriter.c();
        }
        ByteVector byteVector = this.innerClasses;
        if (byteVector != null) {
            i17 += byteVector.f27350b + 8;
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_INNER_CLASSES);
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.enclosingClassIndex != 0) {
            i11++;
            i17 += 10;
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_ENCLOSING_METHOD);
        }
        if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
            i11++;
            i17 += 6;
            this.symbolTable.r("Synthetic");
        }
        if (this.signatureIndex != 0) {
            i11++;
            i17 += 8;
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_SIGNATURE);
        }
        if (this.sourceFileIndex != 0) {
            i11++;
            i17 += 8;
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_SOURCE_FILE);
        }
        ByteVector byteVector2 = this.debugExtension;
        if (byteVector2 != null) {
            i11++;
            i17 += byteVector2.f27350b + 6;
            this.symbolTable.r("SourceDebugExtension");
        }
        if ((this.accessFlags & 131072) != 0) {
            i11++;
            i17 += 6;
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_DEPRECATED);
        }
        AnnotationWriter annotationWriter = this.lastRuntimeVisibleAnnotation;
        if (annotationWriter != null) {
            i11++;
            i17 += annotationWriter.a(AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS);
        }
        AnnotationWriter annotationWriter2 = this.lastRuntimeInvisibleAnnotation;
        if (annotationWriter2 != null) {
            i11++;
            i17 += annotationWriter2.a(AttributeLayout.ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS);
        }
        AnnotationWriter annotationWriter3 = this.lastRuntimeVisibleTypeAnnotation;
        if (annotationWriter3 != null) {
            i11++;
            i17 += annotationWriter3.a("RuntimeVisibleTypeAnnotations");
        }
        AnnotationWriter annotationWriter4 = this.lastRuntimeInvisibleTypeAnnotation;
        if (annotationWriter4 != null) {
            i11++;
            i17 += annotationWriter4.a("RuntimeInvisibleTypeAnnotations");
        }
        if (this.symbolTable.v() > 0) {
            i11++;
            i17 += this.symbolTable.v();
        }
        ModuleWriter moduleWriter2 = this.moduleWriter;
        if (moduleWriter2 != null) {
            i11 += moduleWriter2.b();
            i17 += this.moduleWriter.a();
        }
        if (this.nestHostClassIndex != 0) {
            i11++;
            i17 += 8;
            this.symbolTable.r("NestHost");
        }
        ByteVector byteVector3 = this.nestMemberClasses;
        if (byteVector3 != null) {
            i11++;
            i17 += byteVector3.f27350b + 8;
            this.symbolTable.r("NestMembers");
        }
        ByteVector byteVector4 = this.permittedSubclasses;
        if (byteVector4 != null) {
            i11++;
            i17 += byteVector4.f27350b + 8;
            this.symbolTable.r("PermittedSubclasses");
        }
        String str = "PermittedSubclasses";
        if ((this.accessFlags & 65536) == 0 && this.firstRecordComponent == null) {
            i13 = 0;
            i12 = 0;
        } else {
            i13 = 0;
            i12 = 0;
            for (RecordComponentWriter recordComponentWriter = this.firstRecordComponent; recordComponentWriter != null; recordComponentWriter = (RecordComponentWriter) recordComponentWriter.f27405b) {
                i12++;
                i13 += recordComponentWriter.b();
            }
            i11++;
            i17 += i13 + 8;
            this.symbolTable.r("Record");
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i17 += this.firstAttribute.a(this.symbolTable);
            i11 += attribute.d();
        }
        int y11 = i17 + this.symbolTable.y();
        int x11 = this.symbolTable.x();
        String str2 = "Record";
        if (x11 <= 65535) {
            ByteVector byteVector5 = new ByteVector(y11);
            byteVector5.putInt(-889275714).putInt(this.version);
            this.symbolTable.D(byteVector5);
            if ((this.version & 65535) < 49) {
                i14 = 4096;
            } else {
                i14 = 0;
            }
            byteVector5.putShort((~i14) & this.accessFlags).putShort(this.thisClass).putShort(this.superClass);
            byteVector5.putShort(this.interfaceCount);
            for (int i21 = 0; i21 < this.interfaceCount; i21++) {
                byteVector5.putShort(this.interfaces[i21]);
            }
            byteVector5.putShort(i18);
            for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.f27379b) {
                fieldWriter2.c(byteVector5);
            }
            byteVector5.putShort(i19);
            boolean z11 = false;
            boolean z12 = false;
            for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.f27400c) {
                z11 |= methodWriter2.e();
                z12 |= methodWriter2.d();
                methodWriter2.f(byteVector5);
            }
            byteVector5.putShort(i11);
            if (this.innerClasses != null) {
                ByteVector putShort = byteVector5.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_INNER_CLASSES)).putInt(this.innerClasses.f27350b + 2).putShort(this.numberOfInnerClasses);
                ByteVector byteVector6 = this.innerClasses;
                putShort.putByteArray(byteVector6.f27349a, 0, byteVector6.f27350b);
            }
            if (this.enclosingClassIndex != 0) {
                byteVector5.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_ENCLOSING_METHOD)).putInt(4).putShort(this.enclosingClassIndex).putShort(this.enclosingMethodIndex);
            }
            if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
                byteVector5.putShort(this.symbolTable.r("Synthetic")).putInt(0);
            }
            if (this.signatureIndex != 0) {
                i15 = 2;
                byteVector5.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_SIGNATURE)).putInt(2).putShort(this.signatureIndex);
            } else {
                i15 = 2;
            }
            if (this.sourceFileIndex != 0) {
                byteVector5.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_SOURCE_FILE)).putInt(i15).putShort(this.sourceFileIndex);
            }
            ByteVector byteVector7 = this.debugExtension;
            if (byteVector7 != null) {
                int i22 = byteVector7.f27350b;
                i16 = 0;
                byteVector5.putShort(this.symbolTable.r("SourceDebugExtension")).putInt(i22).putByteArray(this.debugExtension.f27349a, 0, i22);
            } else {
                i16 = 0;
            }
            if ((this.accessFlags & 131072) != 0) {
                byteVector5.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_DEPRECATED)).putInt(i16);
            }
            AnnotationWriter.g(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector5);
            this.symbolTable.C(byteVector5);
            ModuleWriter moduleWriter3 = this.moduleWriter;
            if (moduleWriter3 != null) {
                moduleWriter3.c(byteVector5);
            }
            if (this.nestHostClassIndex != 0) {
                byteVector5.putShort(this.symbolTable.r("NestHost")).putInt(2).putShort(this.nestHostClassIndex);
            }
            if (this.nestMemberClasses != null) {
                ByteVector putShort2 = byteVector5.putShort(this.symbolTable.r("NestMembers")).putInt(this.nestMemberClasses.f27350b + 2).putShort(this.numberOfNestMemberClasses);
                ByteVector byteVector8 = this.nestMemberClasses;
                putShort2.putByteArray(byteVector8.f27349a, 0, byteVector8.f27350b);
            }
            if (this.permittedSubclasses != null) {
                ByteVector putShort3 = byteVector5.putShort(this.symbolTable.r(str)).putInt(this.permittedSubclasses.f27350b + 2).putShort(this.numberOfPermittedSubclasses);
                ByteVector byteVector9 = this.permittedSubclasses;
                putShort3.putByteArray(byteVector9.f27349a, 0, byteVector9.f27350b);
            }
            if (!((this.accessFlags & 65536) == 0 && this.firstRecordComponent == null)) {
                byteVector5.putShort(this.symbolTable.r(str2)).putInt(i13 + 2).putShort(i12);
                for (RecordComponentWriter recordComponentWriter2 = this.firstRecordComponent; recordComponentWriter2 != null; recordComponentWriter2 = (RecordComponentWriter) recordComponentWriter2.f27405b) {
                    recordComponentWriter2.c(byteVector5);
                }
            }
            Attribute attribute2 = this.firstAttribute;
            if (attribute2 != null) {
                attribute2.f(this.symbolTable, byteVector5);
            }
            if (z12) {
                return replaceAsmInstructions(byteVector5.f27349a, z11);
            }
            return byteVector5.f27349a;
        }
        throw new ClassTooLargeException(this.symbolTable.w(), x11);
    }

    public final void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
        int i13;
        this.version = i11;
        this.accessFlags = i12;
        int i14 = i11 & 65535;
        this.thisClass = this.symbolTable.E(i14, str);
        if (str2 != null) {
            this.signatureIndex = this.symbolTable.r(str2);
        }
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = this.symbolTable.c(str3).f27406a;
        }
        this.superClass = i13;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.interfaceCount = length;
            this.interfaces = new int[length];
            for (int i15 = 0; i15 < this.interfaceCount; i15++) {
                this.interfaces[i15] = this.symbolTable.c(strArr[i15]).f27406a;
            }
        }
        if (this.compute == 1 && i14 >= 51) {
            this.compute = 2;
        }
    }

    public final AnnotationVisitor visitAnnotation(String str, boolean z11) {
        if (z11) {
            AnnotationWriter e11 = AnnotationWriter.e(this.symbolTable, str, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = e11;
            return e11;
        }
        AnnotationWriter e12 = AnnotationWriter.e(this.symbolTable, str, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = e12;
        return e12;
    }

    public final void visitAttribute(Attribute attribute) {
        attribute.f27348a = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    public final void visitEnd() {
    }

    public final FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
        FieldWriter fieldWriter = new FieldWriter(this.symbolTable, i11, str, str2, str3, obj);
        if (this.firstField == null) {
            this.firstField = fieldWriter;
        } else {
            this.lastField.f27379b = fieldWriter;
        }
        this.lastField = fieldWriter;
        return fieldWriter;
    }

    public final void visitInnerClass(String str, String str2, String str3, int i11) {
        int i12;
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Symbol c11 = this.symbolTable.c(str);
        if (c11.f27412g == 0) {
            this.numberOfInnerClasses++;
            this.innerClasses.putShort(c11.f27406a);
            ByteVector byteVector = this.innerClasses;
            int i13 = 0;
            if (str2 == null) {
                i12 = 0;
            } else {
                i12 = this.symbolTable.c(str2).f27406a;
            }
            byteVector.putShort(i12);
            ByteVector byteVector2 = this.innerClasses;
            if (str3 != null) {
                i13 = this.symbolTable.r(str3);
            }
            byteVector2.putShort(i13);
            this.innerClasses.putShort(i11);
            c11.f27412g = this.numberOfInnerClasses;
        }
    }

    public final MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
        MethodWriter methodWriter = new MethodWriter(this.symbolTable, i11, str, str2, str3, strArr, this.compute);
        if (this.firstMethod == null) {
            this.firstMethod = methodWriter;
        } else {
            this.lastMethod.f27400c = methodWriter;
        }
        this.lastMethod = methodWriter;
        return methodWriter;
    }

    public final ModuleVisitor visitModule(String str, int i11, String str2) {
        int i12;
        SymbolTable symbolTable2 = this.symbolTable;
        int i13 = symbolTable2.n(str).f27406a;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = this.symbolTable.r(str2);
        }
        ModuleWriter moduleWriter2 = new ModuleWriter(symbolTable2, i13, i11, i12);
        this.moduleWriter = moduleWriter2;
        return moduleWriter2;
    }

    public final void visitNestHost(String str) {
        this.nestHostClassIndex = this.symbolTable.c(str).f27406a;
    }

    public final void visitNestMember(String str) {
        if (this.nestMemberClasses == null) {
            this.nestMemberClasses = new ByteVector();
        }
        this.numberOfNestMemberClasses++;
        this.nestMemberClasses.putShort(this.symbolTable.c(str).f27406a);
    }

    public final void visitOuterClass(String str, String str2, String str3) {
        this.enclosingClassIndex = this.symbolTable.c(str).f27406a;
        if (str2 != null && str3 != null) {
            this.enclosingMethodIndex = this.symbolTable.o(str2, str3);
        }
    }

    public final void visitPermittedSubclass(String str) {
        if (this.permittedSubclasses == null) {
            this.permittedSubclasses = new ByteVector();
        }
        this.numberOfPermittedSubclasses++;
        this.permittedSubclasses.putShort(this.symbolTable.c(str).f27406a);
    }

    public final RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        RecordComponentWriter recordComponentWriter = new RecordComponentWriter(this.symbolTable, str, str2, str3);
        if (this.firstRecordComponent == null) {
            this.firstRecordComponent = recordComponentWriter;
        } else {
            this.lastRecordComponent.f27405b = recordComponentWriter;
        }
        this.lastRecordComponent = recordComponentWriter;
        return recordComponentWriter;
    }

    public final void visitSource(String str, String str2) {
        if (str != null) {
            this.sourceFileIndex = this.symbolTable.r(str);
        }
        if (str2 != null) {
            this.debugExtension = new ByteVector().a(str2, 0, Integer.MAX_VALUE);
        }
    }

    public final AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (z11) {
            AnnotationWriter d11 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = d11;
            return d11;
        }
        AnnotationWriter d12 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = d12;
        return d12;
    }

    public ClassWriter(ClassReader classReader, int i11) {
        super(Opcodes.ASM9);
        this.symbolTable = classReader == null ? new SymbolTable(this) : new SymbolTable(this, classReader);
        if ((i11 & 2) != 0) {
            this.compute = 4;
        } else if ((i11 & 1) != 0) {
            this.compute = 1;
        } else {
            this.compute = 0;
        }
    }

    public int newHandle(int i11, String str, String str2, String str3, boolean z11) {
        return this.symbolTable.k(i11, str, str2, str3, z11).f27406a;
    }
}
