package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

public class Zip64ExtendedInformationExtraField implements ZipExtraField {
    static final ZipShort HEADER_ID = new ZipShort(1);
    private static final String LFH_MUST_HAVE_BOTH_SIZES_MSG = "Zip64 extended information must contain both size values in the local file header.";
    private ZipEightByteInteger compressedSize;
    private ZipLong diskStart;
    private byte[] rawCentralDirectoryData;
    private ZipEightByteInteger relativeHeaderOffset;
    private ZipEightByteInteger size;

    public Zip64ExtendedInformationExtraField() {
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger zipEightByteInteger, ZipEightByteInteger zipEightByteInteger2) {
        this(zipEightByteInteger, zipEightByteInteger2, (ZipEightByteInteger) null, (ZipLong) null);
    }

    private int addSizes(byte[] bArr) {
        int i11;
        ZipEightByteInteger zipEightByteInteger = this.size;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, 0, 8);
            i11 = 8;
        } else {
            i11 = 0;
        }
        ZipEightByteInteger zipEightByteInteger2 = this.compressedSize;
        if (zipEightByteInteger2 == null) {
            return i11;
        }
        System.arraycopy(zipEightByteInteger2.getBytes(), 0, bArr, i11, 8);
        return i11 + 8;
    }

    public byte[] getCentralDirectoryData() {
        byte[] bArr = new byte[getCentralDirectoryLength().getValue()];
        int addSizes = addSizes(bArr);
        ZipEightByteInteger zipEightByteInteger = this.relativeHeaderOffset;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, addSizes, 8);
            addSizes += 8;
        }
        ZipLong zipLong = this.diskStart;
        if (zipLong != null) {
            System.arraycopy(zipLong.getBytes(), 0, bArr, addSizes, 4);
        }
        return bArr;
    }

    public ZipShort getCentralDirectoryLength() {
        int i11 = 8;
        int i12 = 0;
        int i13 = (this.size != null ? 8 : 0) + (this.compressedSize != null ? 8 : 0);
        if (this.relativeHeaderOffset == null) {
            i11 = 0;
        }
        int i14 = i13 + i11;
        if (this.diskStart != null) {
            i12 = 4;
        }
        return new ZipShort(i14 + i12);
    }

    public ZipEightByteInteger getCompressedSize() {
        return this.compressedSize;
    }

    public ZipLong getDiskStartNumber() {
        return this.diskStart;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        ZipEightByteInteger zipEightByteInteger = this.size;
        if (zipEightByteInteger == null && this.compressedSize == null) {
            return ByteUtils.EMPTY_BYTE_ARRAY;
        }
        if (zipEightByteInteger == null || this.compressedSize == null) {
            throw new IllegalArgumentException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
        }
        byte[] bArr = new byte[16];
        addSizes(bArr);
        return bArr;
    }

    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.size != null ? 16 : 0);
    }

    public ZipEightByteInteger getRelativeHeaderOffset() {
        return this.relativeHeaderOffset;
    }

    public ZipEightByteInteger getSize() {
        return this.size;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        byte[] bArr2 = new byte[i12];
        this.rawCentralDirectoryData = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        if (i12 >= 28) {
            parseFromLocalFileData(bArr, i11, i12);
        } else if (i12 == 24) {
            this.size = new ZipEightByteInteger(bArr, i11);
            int i13 = i11 + 8;
            this.compressedSize = new ZipEightByteInteger(bArr, i13);
            this.relativeHeaderOffset = new ZipEightByteInteger(bArr, i13 + 8);
        } else if (i12 % 8 == 4) {
            this.diskStart = new ZipLong(bArr, (i11 + i12) - 4);
        }
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 != 0) {
            if (i12 >= 16) {
                this.size = new ZipEightByteInteger(bArr, i11);
                int i13 = i11 + 8;
                this.compressedSize = new ZipEightByteInteger(bArr, i13);
                int i14 = i13 + 8;
                int i15 = i12 - 16;
                if (i15 >= 8) {
                    this.relativeHeaderOffset = new ZipEightByteInteger(bArr, i14);
                    i14 += 8;
                    i15 -= 8;
                }
                if (i15 >= 4) {
                    this.diskStart = new ZipLong(bArr, i14);
                    return;
                }
                return;
            }
            throw new ZipException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
        }
    }

    public void reparseCentralDirectoryData(boolean z11, boolean z12, boolean z13, boolean z14) throws ZipException {
        int i11;
        int i12;
        int i13;
        int i14;
        byte[] bArr = this.rawCentralDirectoryData;
        if (bArr != null) {
            int i15 = 0;
            if (z11) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            if (z12) {
                i12 = 8;
            } else {
                i12 = 0;
            }
            int i16 = i11 + i12;
            if (z13) {
                i13 = 8;
            } else {
                i13 = 0;
            }
            int i17 = i16 + i13;
            if (z14) {
                i14 = 4;
            } else {
                i14 = 0;
            }
            int i18 = i17 + i14;
            if (bArr.length >= i18) {
                if (z11) {
                    this.size = new ZipEightByteInteger(this.rawCentralDirectoryData, 0);
                    i15 = 8;
                }
                if (z12) {
                    this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, i15);
                    i15 += 8;
                }
                if (z13) {
                    this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, i15);
                    i15 += 8;
                }
                if (z14) {
                    this.diskStart = new ZipLong(this.rawCentralDirectoryData, i15);
                    return;
                }
                return;
            }
            throw new ZipException("Central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i18 + " but is " + this.rawCentralDirectoryData.length);
        }
    }

    public void setCompressedSize(ZipEightByteInteger zipEightByteInteger) {
        this.compressedSize = zipEightByteInteger;
    }

    public void setDiskStartNumber(ZipLong zipLong) {
        this.diskStart = zipLong;
    }

    public void setRelativeHeaderOffset(ZipEightByteInteger zipEightByteInteger) {
        this.relativeHeaderOffset = zipEightByteInteger;
    }

    public void setSize(ZipEightByteInteger zipEightByteInteger) {
        this.size = zipEightByteInteger;
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger zipEightByteInteger, ZipEightByteInteger zipEightByteInteger2, ZipEightByteInteger zipEightByteInteger3, ZipLong zipLong) {
        this.size = zipEightByteInteger;
        this.compressedSize = zipEightByteInteger2;
        this.relativeHeaderOffset = zipEightByteInteger3;
        this.diskStart = zipLong;
    }
}
