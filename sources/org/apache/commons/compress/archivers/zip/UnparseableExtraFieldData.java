package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

public final class UnparseableExtraFieldData implements ZipExtraField {
    private static final ZipShort HEADER_ID = new ZipShort(44225);
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralDirectoryData;
        if (bArr == null) {
            return getLocalFileDataData();
        }
        return ZipUtil.copy(bArr);
    }

    public ZipShort getCentralDirectoryLength() {
        if (this.centralDirectoryData == null) {
            return getLocalFileDataLength();
        }
        return new ZipShort(this.centralDirectoryData.length);
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.localFileData;
        return new ZipShort(bArr == null ? 0 : bArr.length);
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        this.centralDirectoryData = Arrays.copyOfRange(bArr, i11, i11 + i12);
        if (this.localFileData == null) {
            parseFromLocalFileData(bArr, i11, i12);
        }
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        this.localFileData = Arrays.copyOfRange(bArr, i11, i12 + i11);
    }
}
