package org.apache.commons.compress.archivers.zip;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public abstract class AbstractUnicodeExtraField implements ZipExtraField {
    private byte[] data;
    private long nameCRC32;
    private byte[] unicodeName;

    public AbstractUnicodeExtraField() {
    }

    private void assembleData() {
        byte[] bArr = this.unicodeName;
        if (bArr != null) {
            byte[] bArr2 = new byte[(bArr.length + 5)];
            this.data = bArr2;
            bArr2[0] = 1;
            System.arraycopy(ZipLong.getBytes(this.nameCRC32), 0, this.data, 1, 4);
            byte[] bArr3 = this.unicodeName;
            System.arraycopy(bArr3, 0, this.data, 5, bArr3.length);
        }
    }

    public byte[] getCentralDirectoryData() {
        if (this.data == null) {
            assembleData();
        }
        byte[] bArr = this.data;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public ZipShort getCentralDirectoryLength() {
        int i11;
        if (this.data == null) {
            assembleData();
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            i11 = bArr.length;
        } else {
            i11 = 0;
        }
        return new ZipShort(i11);
    }

    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    public ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    public long getNameCRC32() {
        return this.nameCRC32;
    }

    public byte[] getUnicodeName() {
        byte[] bArr = this.unicodeName;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromLocalFileData(bArr, i11, i12);
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 >= 5) {
            byte b11 = bArr[i11];
            if (b11 == 1) {
                this.nameCRC32 = ZipLong.getValue(bArr, i11 + 1);
                int i13 = i12 - 5;
                byte[] bArr2 = new byte[i13];
                this.unicodeName = bArr2;
                System.arraycopy(bArr, i11 + 5, bArr2, 0, i13);
                this.data = null;
                return;
            }
            throw new ZipException("Unsupported version [" + b11 + "] for UniCode path extra data.");
        }
        throw new ZipException("UniCode path extra data must have at least 5 bytes.");
    }

    public void setNameCRC32(long j11) {
        this.nameCRC32 = j11;
        this.data = null;
    }

    public void setUnicodeName(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.unicodeName = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.unicodeName = null;
        }
        this.data = null;
    }

    public AbstractUnicodeExtraField(String str, byte[] bArr, int i11, int i12) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i11, i12);
        this.nameCRC32 = crc32.getValue();
        this.unicodeName = str.getBytes(StandardCharsets.UTF_8);
    }

    public AbstractUnicodeExtraField(String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }
}
