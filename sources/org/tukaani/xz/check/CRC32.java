package org.tukaani.xz.check;

public class CRC32 extends Check {
    private final java.util.zip.CRC32 state = new java.util.zip.CRC32();

    public CRC32() {
        this.f63419a = 4;
        this.f63420b = "CRC32";
    }

    public byte[] finish() {
        long value = this.state.getValue();
        byte[] bArr = {(byte) ((int) value), (byte) ((int) (value >>> 8)), (byte) ((int) (value >>> 16)), (byte) ((int) (value >>> 24))};
        this.state.reset();
        return bArr;
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.state.update(bArr, i11, i12);
    }
}
