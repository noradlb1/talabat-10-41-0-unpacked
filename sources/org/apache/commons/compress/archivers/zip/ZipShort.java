package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import org.apache.commons.compress.utils.ByteUtils;

public final class ZipShort implements Cloneable, Serializable {
    public static final ZipShort ZERO = new ZipShort(0);
    private static final long serialVersionUID = 1;
    private final int value;

    public ZipShort(int i11) {
        this.value = i11;
    }

    public static void putShort(int i11, byte[] bArr, int i12) {
        ByteUtils.toLittleEndian(bArr, (long) i11, i12, 2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue()) {
            return true;
        }
        return false;
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[2];
        ByteUtils.toLittleEndian(bArr, (long) this.value, 0, 2);
        return bArr;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }

    public static byte[] getBytes(int i11) {
        byte[] bArr = new byte[2];
        putShort(i11, bArr, 0);
        return bArr;
    }

    public static int getValue(byte[] bArr, int i11) {
        return (int) ByteUtils.fromLittleEndian(bArr, i11, 2);
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public static int getValue(byte[] bArr) {
        return getValue(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i11) {
        this.value = getValue(bArr, i11);
    }
}
