package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final ZipShort HEADER_ID = new ZipShort(30837);
    private static final BigInteger ONE_THOUSAND = BigInteger.valueOf(1000);
    private static final ZipShort ZERO = new ZipShort(0);
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;

    public X7875_NewUnix() {
        reset();
    }

    private void reset() {
        BigInteger bigInteger = ONE_THOUSAND;
        this.uid = bigInteger;
        this.gid = bigInteger;
    }

    public static byte[] trimLeadingZeroesForceMinLength(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length && bArr[i11] == 0) {
            i12++;
            i11++;
        }
        int max = Math.max(1, bArr.length - i12);
        byte[] bArr2 = new byte[max];
        int length2 = max - (bArr.length - i12);
        System.arraycopy(bArr, i12, bArr2, length2, max - length2);
        return bArr2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X7875_NewUnix)) {
            return false;
        }
        X7875_NewUnix x7875_NewUnix = (X7875_NewUnix) obj;
        if (this.version != x7875_NewUnix.version || !this.uid.equals(x7875_NewUnix.uid) || !this.gid.equals(x7875_NewUnix.gid)) {
            return false;
        }
        return true;
    }

    public byte[] getCentralDirectoryData() {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public byte[] getLocalFileDataData() {
        int i11;
        int i12;
        byte[] byteArray = this.uid.toByteArray();
        byte[] byteArray2 = this.gid.toByteArray();
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(byteArray);
        if (trimLeadingZeroesForceMinLength != null) {
            i11 = trimLeadingZeroesForceMinLength.length;
        } else {
            i11 = 0;
        }
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(byteArray2);
        if (trimLeadingZeroesForceMinLength2 != null) {
            i12 = trimLeadingZeroesForceMinLength2.length;
        } else {
            i12 = 0;
        }
        byte[] bArr = new byte[(i11 + 3 + i12)];
        if (trimLeadingZeroesForceMinLength != null) {
            ZipUtil.reverse(trimLeadingZeroesForceMinLength);
        }
        if (trimLeadingZeroesForceMinLength2 != null) {
            ZipUtil.reverse(trimLeadingZeroesForceMinLength2);
        }
        bArr[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        bArr[1] = ZipUtil.unsignedIntToSignedByte(i11);
        if (trimLeadingZeroesForceMinLength != null) {
            System.arraycopy(trimLeadingZeroesForceMinLength, 0, bArr, 2, i11);
        }
        int i13 = 2 + i11;
        int i14 = i13 + 1;
        bArr[i13] = ZipUtil.unsignedIntToSignedByte(i12);
        if (trimLeadingZeroesForceMinLength2 != null) {
            System.arraycopy(trimLeadingZeroesForceMinLength2, 0, bArr, i14, i12);
        }
        return bArr;
    }

    public ZipShort getLocalFileDataLength() {
        int i11;
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int i12 = 0;
        if (trimLeadingZeroesForceMinLength == null) {
            i11 = 0;
        } else {
            i11 = trimLeadingZeroesForceMinLength.length;
        }
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        if (trimLeadingZeroesForceMinLength2 != null) {
            i12 = trimLeadingZeroesForceMinLength2.length;
        }
        return new ZipShort(i11 + 3 + i12);
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public int hashCode() {
        return (Integer.rotateLeft(this.uid.hashCode(), 16) ^ (this.version * -1234567)) ^ this.gid.hashCode();
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        reset();
        if (i12 >= 3) {
            int i13 = i11 + 1;
            this.version = ZipUtil.signedByteToUnsignedInt(bArr[i11]);
            int i14 = i13 + 1;
            int signedByteToUnsignedInt = ZipUtil.signedByteToUnsignedInt(bArr[i13]);
            int i15 = signedByteToUnsignedInt + 3;
            if (i15 <= i12) {
                int i16 = signedByteToUnsignedInt + i14;
                this.uid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i14, i16)));
                int i17 = i16 + 1;
                int signedByteToUnsignedInt2 = ZipUtil.signedByteToUnsignedInt(bArr[i16]);
                if (i15 + signedByteToUnsignedInt2 <= i12) {
                    this.gid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i17, signedByteToUnsignedInt2 + i17)));
                    return;
                }
                throw new ZipException("X7875_NewUnix invalid: gidSize " + signedByteToUnsignedInt2 + " doesn't fit into " + i12 + " bytes");
            }
            throw new ZipException("X7875_NewUnix invalid: uidSize " + signedByteToUnsignedInt + " doesn't fit into " + i12 + " bytes");
        }
        throw new ZipException("X7875_NewUnix length is too short, only " + i12 + " bytes");
    }

    public void setGID(long j11) {
        this.gid = ZipUtil.longToBig(j11);
    }

    public void setUID(long j11) {
        this.uid = ZipUtil.longToBig(j11);
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }
}
