package net.bytebuddy.jar.asm;

import net.bytebuddy.jar.asm.Attribute;

final class RecordComponentWriter extends RecordComponentVisitor {
    private final int descriptorIndex;
    private Attribute firstAttribute;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private final int nameIndex;
    private int signatureIndex;
    private final SymbolTable symbolTable;

    public RecordComponentWriter(SymbolTable symbolTable2, String str, String str2, String str3) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.nameIndex = symbolTable2.r(str);
        this.descriptorIndex = symbolTable2.r(str2);
        if (str3 != null) {
            this.signatureIndex = symbolTable2.r(str3);
        }
    }

    public final void a(Attribute.Set set) {
        set.a(this.firstAttribute);
    }

    public int b() {
        int b11 = Attribute.b(this.symbolTable, 0, this.signatureIndex) + 6 + AnnotationWriter.b(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            return b11 + attribute.a(this.symbolTable);
        }
        return b11;
    }

    public void c(ByteVector byteVector) {
        int i11;
        byteVector.putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.signatureIndex != 0) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i11++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i11++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i11 += attribute.d();
        }
        byteVector.putShort(i11);
        Attribute.e(this.symbolTable, 0, this.signatureIndex, byteVector);
        AnnotationWriter.g(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, byteVector);
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            attribute2.f(this.symbolTable, byteVector);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z11) {
        if (z11) {
            AnnotationWriter e11 = AnnotationWriter.e(this.symbolTable, str, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = e11;
            return e11;
        }
        AnnotationWriter e12 = AnnotationWriter.e(this.symbolTable, str, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = e12;
        return e12;
    }

    public void visitAttribute(Attribute attribute) {
        attribute.f27348a = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    public void visitEnd() {
    }

    public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
        if (z11) {
            AnnotationWriter d11 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = d11;
            return d11;
        }
        AnnotationWriter d12 = AnnotationWriter.d(this.symbolTable, i11, typePath, str, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = d12;
        return d12;
    }
}
