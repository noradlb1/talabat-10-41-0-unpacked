package net.bytebuddy.jar.asm;

import org.apache.commons.compress.harmony.unpack200.AttributeLayout;

public class Attribute {

    /* renamed from: a  reason: collision with root package name */
    public Attribute f27348a;
    private byte[] content;
    public final String type;

    public static final class Set {
        private static final int SIZE_INCREMENT = 6;
        private Attribute[] data = new Attribute[6];
        private int size;

        private void add(Attribute attribute) {
            int i11 = this.size;
            Attribute[] attributeArr = this.data;
            if (i11 >= attributeArr.length) {
                Attribute[] attributeArr2 = new Attribute[(attributeArr.length + 6)];
                System.arraycopy(attributeArr, 0, attributeArr2, 0, i11);
                this.data = attributeArr2;
            }
            Attribute[] attributeArr3 = this.data;
            int i12 = this.size;
            this.size = i12 + 1;
            attributeArr3[i12] = attribute;
        }

        private boolean contains(Attribute attribute) {
            for (int i11 = 0; i11 < this.size; i11++) {
                if (this.data[i11].type.equals(attribute.type)) {
                    return true;
                }
            }
            return false;
        }

        public void a(Attribute attribute) {
            while (attribute != null) {
                if (!contains(attribute)) {
                    add(attribute);
                }
                attribute = attribute.f27348a;
            }
        }

        public Attribute[] b() {
            int i11 = this.size;
            Attribute[] attributeArr = new Attribute[i11];
            System.arraycopy(this.data, 0, attributeArr, 0, i11);
            return attributeArr;
        }
    }

    public Attribute(String str) {
        this.type = str;
    }

    public static int b(SymbolTable symbolTable, int i11, int i12) {
        int i13;
        if ((i11 & 4096) == 0 || symbolTable.z() >= 49) {
            i13 = 0;
        } else {
            symbolTable.r("Synthetic");
            i13 = 6;
        }
        if (i12 != 0) {
            symbolTable.r(AttributeLayout.ATTRIBUTE_SIGNATURE);
            i13 += 8;
        }
        if ((i11 & 131072) == 0) {
            return i13;
        }
        symbolTable.r(AttributeLayout.ATTRIBUTE_DEPRECATED);
        return i13 + 6;
    }

    public static void e(SymbolTable symbolTable, int i11, int i12, ByteVector byteVector) {
        if ((i11 & 4096) != 0 && symbolTable.z() < 49) {
            byteVector.putShort(symbolTable.r("Synthetic")).putInt(0);
        }
        if (i12 != 0) {
            byteVector.putShort(symbolTable.r(AttributeLayout.ATTRIBUTE_SIGNATURE)).putInt(2).putShort(i12);
        }
        if ((i11 & 131072) != 0) {
            byteVector.putShort(symbolTable.r(AttributeLayout.ATTRIBUTE_DEPRECATED)).putInt(0);
        }
    }

    public final int a(SymbolTable symbolTable) {
        return c(symbolTable, (byte[]) null, 0, -1, -1);
    }

    public final int c(SymbolTable symbolTable, byte[] bArr, int i11, int i12, int i13) {
        ClassWriter classWriter = symbolTable.f27413a;
        int i14 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f27348a) {
            symbolTable.r(attribute.type);
            i14 += attribute.i(classWriter, bArr, i11, i12, i13).f27350b + 6;
        }
        return i14;
    }

    public final int d() {
        int i11 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f27348a) {
            i11++;
        }
        return i11;
    }

    public final void f(SymbolTable symbolTable, ByteVector byteVector) {
        g(symbolTable, (byte[]) null, 0, -1, -1, byteVector);
    }

    public final void g(SymbolTable symbolTable, byte[] bArr, int i11, int i12, int i13, ByteVector byteVector) {
        ClassWriter classWriter = symbolTable.f27413a;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f27348a) {
            ByteVector i14 = attribute.i(classWriter, bArr, i11, i12, i13);
            byteVector.putShort(symbolTable.r(attribute.type)).putInt(i14.f27350b);
            byteVector.putByteArray(i14.f27349a, 0, i14.f27350b);
        }
    }

    public Attribute h(ClassReader classReader, int i11, int i12, char[] cArr, int i13, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        byte[] bArr = new byte[i12];
        attribute.content = bArr;
        System.arraycopy(classReader.f27351a, i11, bArr, 0, i12);
        return attribute;
    }

    public ByteVector i(ClassWriter classWriter, byte[] bArr, int i11, int i12, int i13) {
        return new ByteVector(this.content);
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }
}
