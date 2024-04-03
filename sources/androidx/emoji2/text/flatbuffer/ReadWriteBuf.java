package androidx.emoji2.text.flatbuffer;

interface ReadWriteBuf extends ReadBuf {
    int limit();

    void put(byte b11);

    void put(byte[] bArr, int i11, int i12);

    void putBoolean(boolean z11);

    void putDouble(double d11);

    void putFloat(float f11);

    void putInt(int i11);

    void putLong(long j11);

    void putShort(short s11);

    boolean requestCapacity(int i11);

    void set(int i11, byte b11);

    void set(int i11, byte[] bArr, int i12, int i13);

    void setBoolean(int i11, boolean z11);

    void setDouble(int i11, double d11);

    void setFloat(int i11, float f11);

    void setInt(int i11, int i12);

    void setLong(int i11, long j11);

    void setShort(int i11, short s11);

    int writePosition();
}
