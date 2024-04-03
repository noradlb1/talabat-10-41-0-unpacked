package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

public class UnrecognizedExtraField implements ZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralData;
        if (bArr != null) {
            return ZipUtil.copy(bArr);
        }
        return getLocalFileDataData();
    }

    public ZipShort getCentralDirectoryLength() {
        if (this.centralData != null) {
            return new ZipShort(this.centralData.length);
        }
        return getLocalFileDataLength();
    }

    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.localData;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
        setCentralDirectoryData(copyOfRange);
        if (this.localData == null) {
            setLocalFileDataData(copyOfRange);
        }
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        setLocalFileDataData(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.centralData = ZipUtil.copy(bArr);
    }

    public void setHeaderId(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.localData = ZipUtil.copy(bArr);
    }
}
