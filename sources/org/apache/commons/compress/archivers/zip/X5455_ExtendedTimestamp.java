package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipException;

public class X5455_ExtendedTimestamp implements ZipExtraField, Cloneable, Serializable {
    public static final byte ACCESS_TIME_BIT = 2;
    public static final byte CREATE_TIME_BIT = 4;
    private static final ZipShort HEADER_ID = new ZipShort(21589);
    public static final byte MODIFY_TIME_BIT = 1;
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    private static ZipLong dateToZipLong(Date date) {
        if (date == null) {
            return null;
        }
        return unixTimeToZipLong(date.getTime() / 1000);
    }

    private void reset() {
        setFlags((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
    }

    private static ZipLong unixTimeToZipLong(long j11) {
        if (j11 >= -2147483648L && j11 <= 2147483647L) {
            return new ZipLong(j11);
        }
        throw new IllegalArgumentException("X5455 timestamps must fit in a signed 32 bit integer: " + j11);
    }

    private static Date zipLongToDate(ZipLong zipLong) {
        if (zipLong != null) {
            return new Date(((long) zipLong.getIntValue()) * 1000);
        }
        return null;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X5455_ExtendedTimestamp)) {
            return false;
        }
        X5455_ExtendedTimestamp x5455_ExtendedTimestamp = (X5455_ExtendedTimestamp) obj;
        if ((this.flags & 7) != (x5455_ExtendedTimestamp.flags & 7)) {
            return false;
        }
        ZipLong zipLong = this.modifyTime;
        ZipLong zipLong2 = x5455_ExtendedTimestamp.modifyTime;
        if (zipLong != zipLong2 && (zipLong == null || !zipLong.equals(zipLong2))) {
            return false;
        }
        ZipLong zipLong3 = this.accessTime;
        ZipLong zipLong4 = x5455_ExtendedTimestamp.accessTime;
        if (zipLong3 != zipLong4 && (zipLong3 == null || !zipLong3.equals(zipLong4))) {
            return false;
        }
        ZipLong zipLong5 = this.createTime;
        ZipLong zipLong6 = x5455_ExtendedTimestamp.createTime;
        if (zipLong5 == zipLong6 || (zipLong5 != null && zipLong5.equals(zipLong6))) {
            return true;
        }
        return false;
    }

    public Date getAccessJavaTime() {
        return zipLongToDate(this.accessTime);
    }

    public ZipLong getAccessTime() {
        return this.accessTime;
    }

    public byte[] getCentralDirectoryData() {
        return Arrays.copyOf(getLocalFileDataData(), getCentralDirectoryLength().getValue());
    }

    public ZipShort getCentralDirectoryLength() {
        return new ZipShort((this.bit0_modifyTimePresent ? 4 : 0) + 1);
    }

    public Date getCreateJavaTime() {
        return zipLongToDate(this.createTime);
    }

    public ZipLong getCreateTime() {
        return this.createTime;
    }

    public byte getFlags() {
        return this.flags;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        ZipLong zipLong;
        ZipLong zipLong2;
        byte[] bArr = new byte[getLocalFileDataLength().getValue()];
        bArr[0] = 0;
        int i11 = 1;
        if (this.bit0_modifyTimePresent) {
            bArr[0] = (byte) (0 | 1);
            System.arraycopy(this.modifyTime.getBytes(), 0, bArr, 1, 4);
            i11 = 5;
        }
        if (this.bit1_accessTimePresent && (zipLong2 = this.accessTime) != null) {
            bArr[0] = (byte) (bArr[0] | 2);
            System.arraycopy(zipLong2.getBytes(), 0, bArr, i11, 4);
            i11 += 4;
        }
        if (this.bit2_createTimePresent && (zipLong = this.createTime) != null) {
            bArr[0] = (byte) (bArr[0] | 4);
            System.arraycopy(zipLong.getBytes(), 0, bArr, i11, 4);
        }
        return bArr;
    }

    public ZipShort getLocalFileDataLength() {
        int i11 = 4;
        int i12 = (this.bit0_modifyTimePresent ? 4 : 0) + 1 + ((!this.bit1_accessTimePresent || this.accessTime == null) ? 0 : 4);
        if (!this.bit2_createTimePresent || this.createTime == null) {
            i11 = 0;
        }
        return new ZipShort(i12 + i11);
    }

    public Date getModifyJavaTime() {
        return zipLongToDate(this.modifyTime);
    }

    public ZipLong getModifyTime() {
        return this.modifyTime;
    }

    public int hashCode() {
        int i11 = (this.flags & 7) * -123;
        ZipLong zipLong = this.modifyTime;
        if (zipLong != null) {
            i11 ^= zipLong.hashCode();
        }
        ZipLong zipLong2 = this.accessTime;
        if (zipLong2 != null) {
            i11 ^= Integer.rotateLeft(zipLong2.hashCode(), 11);
        }
        ZipLong zipLong3 = this.createTime;
        if (zipLong3 != null) {
            return i11 ^ Integer.rotateLeft(zipLong3.hashCode(), 22);
        }
        return i11;
    }

    public boolean isBit0_modifyTimePresent() {
        return this.bit0_modifyTimePresent;
    }

    public boolean isBit1_accessTimePresent() {
        return this.bit1_accessTimePresent;
    }

    public boolean isBit2_createTimePresent() {
        return this.bit2_createTimePresent;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        reset();
        parseFromLocalFileData(bArr, i11, i12);
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        int i13;
        int i14;
        reset();
        if (i12 >= 1) {
            int i15 = i12 + i11;
            int i16 = i11 + 1;
            setFlags(bArr[i11]);
            if (!this.bit0_modifyTimePresent || (i14 = i16 + 4) > i15) {
                this.bit0_modifyTimePresent = false;
            } else {
                this.modifyTime = new ZipLong(bArr, i16);
                i16 = i14;
            }
            if (!this.bit1_accessTimePresent || (i13 = i16 + 4) > i15) {
                this.bit1_accessTimePresent = false;
            } else {
                this.accessTime = new ZipLong(bArr, i16);
                i16 = i13;
            }
            if (!this.bit2_createTimePresent || i16 + 4 > i15) {
                this.bit2_createTimePresent = false;
            } else {
                this.createTime = new ZipLong(bArr, i16);
            }
        } else {
            throw new ZipException("X5455_ExtendedTimestamp too short, only " + i12 + " bytes");
        }
    }

    public void setAccessJavaTime(Date date) {
        setAccessTime(dateToZipLong(date));
    }

    public void setAccessTime(ZipLong zipLong) {
        boolean z11;
        byte b11;
        if (zipLong != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.bit1_accessTimePresent = z11;
        byte b12 = this.flags;
        if (zipLong != null) {
            b11 = b12 | 2;
        } else {
            b11 = b12 & -3;
        }
        this.flags = (byte) b11;
        this.accessTime = zipLong;
    }

    public void setCreateJavaTime(Date date) {
        setCreateTime(dateToZipLong(date));
    }

    public void setCreateTime(ZipLong zipLong) {
        boolean z11;
        byte b11;
        if (zipLong != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.bit2_createTimePresent = z11;
        byte b12 = this.flags;
        if (zipLong != null) {
            b11 = b12 | 4;
        } else {
            b11 = b12 & -5;
        }
        this.flags = (byte) b11;
        this.createTime = zipLong;
    }

    public void setFlags(byte b11) {
        boolean z11;
        boolean z12;
        this.flags = b11;
        boolean z13 = false;
        if ((b11 & 1) == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.bit0_modifyTimePresent = z11;
        if ((b11 & 2) == 2) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.bit1_accessTimePresent = z12;
        if ((b11 & 4) == 4) {
            z13 = true;
        }
        this.bit2_createTimePresent = z13;
    }

    public void setModifyJavaTime(Date date) {
        setModifyTime(dateToZipLong(date));
    }

    public void setModifyTime(ZipLong zipLong) {
        boolean z11;
        byte b11;
        if (zipLong != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.bit0_modifyTimePresent = z11;
        if (zipLong != null) {
            b11 = 1 | this.flags;
        } else {
            b11 = this.flags & -2;
        }
        this.flags = (byte) b11;
        this.modifyTime = zipLong;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("0x5455 Zip Extra Field: Flags=");
        sb2.append(Integer.toBinaryString(ZipUtil.unsignedIntToSignedByte(this.flags)));
        sb2.append(" ");
        if (this.bit0_modifyTimePresent && this.modifyTime != null) {
            Date modifyJavaTime = getModifyJavaTime();
            sb2.append(" Modify:[");
            sb2.append(modifyJavaTime);
            sb2.append("] ");
        }
        if (this.bit1_accessTimePresent && this.accessTime != null) {
            Date accessJavaTime = getAccessJavaTime();
            sb2.append(" Access:[");
            sb2.append(accessJavaTime);
            sb2.append("] ");
        }
        if (this.bit2_createTimePresent && this.createTime != null) {
            Date createJavaTime = getCreateJavaTime();
            sb2.append(" Create:[");
            sb2.append(createJavaTime);
            sb2.append("] ");
        }
        return sb2.toString();
    }
}
