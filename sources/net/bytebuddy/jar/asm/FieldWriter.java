package net.bytebuddy.jar.asm;

import net.bytebuddy.jar.asm.Attribute;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;

final class FieldWriter extends FieldVisitor {
    private final int accessFlags;
    private int constantValueIndex;
    private final int descriptorIndex;
    private Attribute firstAttribute;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private final int nameIndex;
    private int signatureIndex;
    private final SymbolTable symbolTable;

    public FieldWriter(SymbolTable symbolTable2, int i11, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.accessFlags = i11;
        this.nameIndex = symbolTable2.r(str);
        this.descriptorIndex = symbolTable2.r(str2);
        if (str3 != null) {
            this.signatureIndex = symbolTable2.r(str3);
        }
        if (obj != null) {
            this.constantValueIndex = symbolTable2.b(obj).f27406a;
        }
    }

    public final void a(Attribute.Set set) {
        set.a(this.firstAttribute);
    }

    public int b() {
        int i11;
        if (this.constantValueIndex != 0) {
            this.symbolTable.r(AttributeLayout.ATTRIBUTE_CONSTANT_VALUE);
            i11 = 16;
        } else {
            i11 = 8;
        }
        int b11 = i11 + Attribute.b(this.symbolTable, this.accessFlags, this.signatureIndex) + AnnotationWriter.b(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            return b11 + attribute.a(this.symbolTable);
        }
        return b11;
    }

    public void c(ByteVector byteVector) {
        boolean z11;
        int i11;
        int i12 = 0;
        if (this.symbolTable.z() < 49) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 4096;
        } else {
            i11 = 0;
        }
        byteVector.putShort((~i11) & this.accessFlags).putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.constantValueIndex != 0) {
            i12 = 1;
        }
        int i13 = this.accessFlags;
        if ((i13 & 4096) != 0 && z11) {
            i12++;
        }
        if (this.signatureIndex != 0) {
            i12++;
        }
        if ((131072 & i13) != 0) {
            i12++;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            i12++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            i12++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            i12++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            i12++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            i12 += attribute.d();
        }
        byteVector.putShort(i12);
        if (this.constantValueIndex != 0) {
            byteVector.putShort(this.symbolTable.r(AttributeLayout.ATTRIBUTE_CONSTANT_VALUE)).putInt(2).putShort(this.constantValueIndex);
        }
        Attribute.e(this.symbolTable, this.accessFlags, this.signatureIndex, byteVector);
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
