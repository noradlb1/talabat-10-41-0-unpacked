package org.apache.commons.compress.archivers.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

public class AsiExtraField implements ZipExtraField, UnixStat, Cloneable {
    private static final ZipShort HEADER_ID = new ZipShort(30062);
    private static final int MIN_SIZE = 14;
    private CRC32 crc = new CRC32();
    private boolean dirFlag;
    private int gid;
    private String link = "";
    private int mode;
    private int uid;

    public Object clone() {
        try {
            AsiExtraField asiExtraField = (AsiExtraField) super.clone();
            asiExtraField.crc = new CRC32();
            return asiExtraField;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public int getGroupId() {
        return this.gid;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public String getLinkedFile() {
        return this.link;
    }

    public byte[] getLocalFileDataData() {
        int value = getLocalFileDataLength().getValue() - 4;
        byte[] bArr = new byte[value];
        System.arraycopy(ZipShort.getBytes(getMode()), 0, bArr, 0, 2);
        byte[] bytes = getLinkedFile().getBytes();
        System.arraycopy(ZipLong.getBytes((long) bytes.length), 0, bArr, 2, 4);
        System.arraycopy(ZipShort.getBytes(getUserId()), 0, bArr, 6, 2);
        System.arraycopy(ZipShort.getBytes(getGroupId()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.crc.reset();
        this.crc.update(bArr);
        byte[] bArr2 = new byte[(value + 4)];
        System.arraycopy(ZipLong.getBytes(this.crc.getValue()), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, value);
        return bArr2;
    }

    public ZipShort getLocalFileDataLength() {
        return new ZipShort(getLinkedFile().getBytes().length + 14);
    }

    public int getMode() {
        return this.mode;
    }

    public int getUserId() {
        return this.uid;
    }

    public boolean isDirectory() {
        return this.dirFlag && !isLink();
    }

    public boolean isLink() {
        return !getLinkedFile().isEmpty();
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromLocalFileData(bArr, i11, i12);
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 >= 14) {
            long value = ZipLong.getValue(bArr, i11);
            int i13 = i12 - 4;
            byte[] bArr2 = new byte[i13];
            boolean z11 = false;
            System.arraycopy(bArr, i11 + 4, bArr2, 0, i13);
            this.crc.reset();
            this.crc.update(bArr2);
            long value2 = this.crc.getValue();
            if (value == value2) {
                int value3 = ZipShort.getValue(bArr2, 0);
                int value4 = (int) ZipLong.getValue(bArr2, 2);
                if (value4 < 0 || value4 > i13 - 10) {
                    throw new ZipException("Bad symbolic link name length " + value4 + " in ASI extra field");
                }
                this.uid = ZipShort.getValue(bArr2, 6);
                this.gid = ZipShort.getValue(bArr2, 8);
                if (value4 == 0) {
                    this.link = "";
                } else {
                    byte[] bArr3 = new byte[value4];
                    System.arraycopy(bArr2, 10, bArr3, 0, value4);
                    this.link = new String(bArr3);
                }
                if ((value3 & 16384) != 0) {
                    z11 = true;
                }
                setDirectory(z11);
                setMode(value3);
                return;
            }
            throw new ZipException("Bad CRC checksum, expected " + Long.toHexString(value) + " instead of " + Long.toHexString(value2));
        }
        throw new ZipException("The length is too short, only " + i12 + " bytes, expected at least " + 14);
    }

    public void setDirectory(boolean z11) {
        this.dirFlag = z11;
        this.mode = getMode(this.mode);
    }

    public void setGroupId(int i11) {
        this.gid = i11;
    }

    public void setLinkedFile(String str) {
        this.link = str;
        this.mode = getMode(this.mode);
    }

    public void setMode(int i11) {
        this.mode = getMode(i11);
    }

    public void setUserId(int i11) {
        this.uid = i11;
    }

    public int getMode(int i11) {
        int i12;
        if (isLink()) {
            i12 = 40960;
        } else {
            i12 = isDirectory() ? 16384 : 32768;
        }
        return (i11 & UnixStat.PERM_MASK) | i12;
    }
}
