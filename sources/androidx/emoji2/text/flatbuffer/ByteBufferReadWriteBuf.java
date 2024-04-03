package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public byte[] data() {
        return this.buffer.array();
    }

    public byte get(int i11) {
        return this.buffer.get(i11);
    }

    public boolean getBoolean(int i11) {
        return get(i11) != 0;
    }

    public double getDouble(int i11) {
        return this.buffer.getDouble(i11);
    }

    public float getFloat(int i11) {
        return this.buffer.getFloat(i11);
    }

    public int getInt(int i11) {
        return this.buffer.getInt(i11);
    }

    public long getLong(int i11) {
        return this.buffer.getLong(i11);
    }

    public short getShort(int i11) {
        return this.buffer.getShort(i11);
    }

    public String getString(int i11, int i12) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i11, i12);
    }

    public int limit() {
        return this.buffer.limit();
    }

    public void put(byte[] bArr, int i11, int i12) {
        this.buffer.put(bArr, i11, i12);
    }

    public void putBoolean(boolean z11) {
        this.buffer.put(z11 ? (byte) 1 : 0);
    }

    public void putDouble(double d11) {
        this.buffer.putDouble(d11);
    }

    public void putFloat(float f11) {
        this.buffer.putFloat(f11);
    }

    public void putInt(int i11) {
        this.buffer.putInt(i11);
    }

    public void putLong(long j11) {
        this.buffer.putLong(j11);
    }

    public void putShort(short s11) {
        this.buffer.putShort(s11);
    }

    public boolean requestCapacity(int i11) {
        return i11 <= this.buffer.limit();
    }

    public void set(int i11, byte b11) {
        requestCapacity(i11 + 1);
        this.buffer.put(i11, b11);
    }

    public void setBoolean(int i11, boolean z11) {
        set(i11, z11 ? (byte) 1 : 0);
    }

    public void setDouble(int i11, double d11) {
        requestCapacity(i11 + 8);
        this.buffer.putDouble(i11, d11);
    }

    public void setFloat(int i11, float f11) {
        requestCapacity(i11 + 4);
        this.buffer.putFloat(i11, f11);
    }

    public void setInt(int i11, int i12) {
        requestCapacity(i11 + 4);
        this.buffer.putInt(i11, i12);
    }

    public void setLong(int i11, long j11) {
        requestCapacity(i11 + 8);
        this.buffer.putLong(i11, j11);
    }

    public void setShort(int i11, short s11) {
        requestCapacity(i11 + 2);
        this.buffer.putShort(i11, s11);
    }

    public int writePosition() {
        return this.buffer.position();
    }

    public void put(byte b11) {
        this.buffer.put(b11);
    }

    public void set(int i11, byte[] bArr, int i12, int i13) {
        requestCapacity((i13 - i12) + i11);
        int position = this.buffer.position();
        this.buffer.position(i11);
        this.buffer.put(bArr, i12, i13);
        this.buffer.position(position);
    }
}
