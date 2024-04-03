package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.util.Arrays;

public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public byte[] data() {
        return this.buffer;
    }

    public byte get(int i11) {
        return this.buffer[i11];
    }

    public boolean getBoolean(int i11) {
        return this.buffer[i11] != 0;
    }

    public double getDouble(int i11) {
        return Double.longBitsToDouble(getLong(i11));
    }

    public float getFloat(int i11) {
        return Float.intBitsToFloat(getInt(i11));
    }

    public int getInt(int i11) {
        byte[] bArr = this.buffer;
        return (bArr[i11] & 255) | (bArr[i11 + 3] << Ascii.CAN) | ((bArr[i11 + 2] & 255) << Ascii.DLE) | ((bArr[i11 + 1] & 255) << 8);
    }

    public long getLong(int i11) {
        byte[] bArr = this.buffer;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i12]) & 255) << 8) | ((((long) bArr[i13]) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24) | ((((long) bArr[i15]) & 255) << 32) | ((((long) bArr[i16]) & 255) << 40) | ((255 & ((long) bArr[i17])) << 48) | (((long) bArr[i17 + 1]) << 56);
    }

    public short getShort(int i11) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i11] & 255) | (bArr[i11 + 1] << 8));
    }

    public String getString(int i11, int i12) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i11, i12);
    }

    public int limit() {
        return this.writePos;
    }

    public void put(byte[] bArr, int i11, int i12) {
        set(this.writePos, bArr, i11, i12);
        this.writePos += i12;
    }

    public void putBoolean(boolean z11) {
        setBoolean(this.writePos, z11);
        this.writePos++;
    }

    public void putDouble(double d11) {
        setDouble(this.writePos, d11);
        this.writePos += 8;
    }

    public void putFloat(float f11) {
        setFloat(this.writePos, f11);
        this.writePos += 4;
    }

    public void putInt(int i11) {
        setInt(this.writePos, i11);
        this.writePos += 4;
    }

    public void putLong(long j11) {
        setLong(this.writePos, j11);
        this.writePos += 8;
    }

    public void putShort(short s11) {
        setShort(this.writePos, s11);
        this.writePos += 2;
    }

    public boolean requestCapacity(int i11) {
        byte[] bArr = this.buffer;
        if (bArr.length > i11) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    public void set(int i11, byte b11) {
        requestCapacity(i11 + 1);
        this.buffer[i11] = b11;
    }

    public void setBoolean(int i11, boolean z11) {
        set(i11, z11 ? (byte) 1 : 0);
    }

    public void setDouble(int i11, double d11) {
        requestCapacity(i11 + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d11);
        int i12 = (int) doubleToRawLongBits;
        byte[] bArr = this.buffer;
        int i13 = i11 + 1;
        bArr[i11] = (byte) (i12 & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i12 >> 8) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i12 >> 16) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((i12 >> 24) & 255);
        int i17 = (int) (doubleToRawLongBits >> 32);
        int i18 = i16 + 1;
        bArr[i16] = (byte) (i17 & 255);
        int i19 = i18 + 1;
        bArr[i18] = (byte) ((i17 >> 8) & 255);
        bArr[i19] = (byte) ((i17 >> 16) & 255);
        bArr[i19 + 1] = (byte) ((i17 >> 24) & 255);
    }

    public void setFloat(int i11, float f11) {
        requestCapacity(i11 + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f11);
        byte[] bArr = this.buffer;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (floatToRawIntBits & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i13] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i13 + 1] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    public void setInt(int i11, int i12) {
        requestCapacity(i11 + 4);
        byte[] bArr = this.buffer;
        int i13 = i11 + 1;
        bArr[i11] = (byte) (i12 & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i12 >> 8) & 255);
        bArr[i14] = (byte) ((i12 >> 16) & 255);
        bArr[i14 + 1] = (byte) ((i12 >> 24) & 255);
    }

    public void setLong(int i11, long j11) {
        requestCapacity(i11 + 8);
        int i12 = (int) j11;
        byte[] bArr = this.buffer;
        int i13 = i11 + 1;
        bArr[i11] = (byte) (i12 & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i12 >> 8) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i12 >> 16) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((i12 >> 24) & 255);
        int i17 = (int) (j11 >> 32);
        int i18 = i16 + 1;
        bArr[i16] = (byte) (i17 & 255);
        int i19 = i18 + 1;
        bArr[i18] = (byte) ((i17 >> 8) & 255);
        bArr[i19] = (byte) ((i17 >> 16) & 255);
        bArr[i19 + 1] = (byte) ((i17 >> 24) & 255);
    }

    public void setShort(int i11, short s11) {
        requestCapacity(i11 + 2);
        byte[] bArr = this.buffer;
        bArr[i11] = (byte) (s11 & 255);
        bArr[i11 + 1] = (byte) ((s11 >> 8) & 255);
    }

    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i11) {
        this(new byte[i11]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    public void put(byte b11) {
        set(this.writePos, b11);
        this.writePos++;
    }

    public void set(int i11, byte[] bArr, int i12, int i13) {
        requestCapacity((i13 - i12) + i11);
        System.arraycopy(bArr, i12, this.buffer, i11, i13);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i11) {
        this.buffer = bArr;
        this.writePos = i11;
    }
}
