package org.apache.commons.compress.archivers.zip;

class CircularBuffer {
    private final byte[] buffer;
    private int readIndex;
    private final int size;
    private int writeIndex;

    public CircularBuffer(int i11) {
        this.size = i11;
        this.buffer = new byte[i11];
    }

    public boolean available() {
        return this.readIndex != this.writeIndex;
    }

    public void copy(int i11, int i12) {
        int i13 = this.writeIndex - i11;
        int i14 = i12 + i13;
        while (i13 < i14) {
            byte[] bArr = this.buffer;
            int i15 = this.writeIndex;
            int i16 = this.size;
            bArr[i15] = bArr[(i13 + i16) % i16];
            this.writeIndex = (i15 + 1) % i16;
            i13++;
        }
    }

    public int get() {
        if (!available()) {
            return -1;
        }
        byte[] bArr = this.buffer;
        int i11 = this.readIndex;
        byte b11 = bArr[i11];
        this.readIndex = (i11 + 1) % this.size;
        return b11 & 255;
    }

    public void put(int i11) {
        byte[] bArr = this.buffer;
        int i12 = this.writeIndex;
        bArr[i12] = (byte) i11;
        this.writeIndex = (i12 + 1) % this.size;
    }
}
