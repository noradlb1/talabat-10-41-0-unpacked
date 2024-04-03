package net.bytebuddy.jar.asm;

import net.bytebuddy.pool.TypePool;

public final class TypePath {
    public static final int ARRAY_ELEMENT = 0;
    public static final int INNER_TYPE = 1;
    public static final int TYPE_ARGUMENT = 3;
    public static final int WILDCARD_BOUND = 2;
    private final byte[] typePathContainer;
    private final int typePathOffset;

    public TypePath(byte[] bArr, int i11) {
        this.typePathContainer = bArr;
        this.typePathOffset = i11;
    }

    public static void a(TypePath typePath, ByteVector byteVector) {
        if (typePath == null) {
            byteVector.putByte(0);
            return;
        }
        byte[] bArr = typePath.typePathContainer;
        int i11 = typePath.typePathOffset;
        byteVector.putByteArray(bArr, i11, (bArr[i11] * 2) + 1);
    }

    public static TypePath fromString(String str) {
        int i11;
        char charAt;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        ByteVector byteVector = new ByteVector(length);
        byteVector.putByte(0);
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 == '[') {
                byteVector.b(0, 0);
            } else if (charAt2 == '.') {
                byteVector.b(1, 0);
            } else if (charAt2 == '*') {
                byteVector.b(2, 0);
            } else if (charAt2 < '0' || charAt2 > '9') {
                throw new IllegalArgumentException();
            } else {
                int i14 = charAt2 - '0';
                while (true) {
                    if (i13 >= length) {
                        break;
                    }
                    i11 = i13 + 1;
                    charAt = str.charAt(i13);
                    if (charAt >= '0' && charAt <= '9') {
                        i14 = ((i14 * 10) + charAt) - 48;
                        i13 = i11;
                    }
                }
                if (charAt == ';') {
                    i13 = i11;
                    byteVector.b(3, i14);
                } else {
                    throw new IllegalArgumentException();
                }
            }
            i12 = i13;
        }
        byte[] bArr = byteVector.f27349a;
        bArr[0] = (byte) (byteVector.f27350b / 2);
        return new TypePath(bArr, 0);
    }

    public int getLength() {
        return this.typePathContainer[this.typePathOffset];
    }

    public int getStep(int i11) {
        return this.typePathContainer[this.typePathOffset + (i11 * 2) + 1];
    }

    public int getStepArgument(int i11) {
        return this.typePathContainer[this.typePathOffset + (i11 * 2) + 2];
    }

    public String toString() {
        int length = getLength();
        StringBuilder sb2 = new StringBuilder(length * 2);
        for (int i11 = 0; i11 < length; i11++) {
            int step = getStep(i11);
            if (step == 0) {
                sb2.append('[');
            } else if (step == 1) {
                sb2.append('.');
            } else if (step == 2) {
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
            } else if (step == 3) {
                sb2.append(getStepArgument(i11));
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            } else {
                throw new AssertionError();
            }
        }
        return sb2.toString();
    }
}
