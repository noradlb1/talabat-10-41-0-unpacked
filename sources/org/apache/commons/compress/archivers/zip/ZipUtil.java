package org.apache.commons.compress.archivers.zip;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;

public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = ZipLong.getBytes(8448);

    public static long adjustToLong(int i11) {
        return i11 < 0 ? ((long) i11) + 4294967296L : (long) i11;
    }

    public static long bigToLong(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + bigInteger + "]");
    }

    public static boolean canHandleEntryData(ZipArchiveEntry zipArchiveEntry) {
        return supportsEncryptionOf(zipArchiveEntry) && supportsMethodOf(zipArchiveEntry);
    }

    public static void checkRequestedFeatures(ZipArchiveEntry zipArchiveEntry) throws UnsupportedZipFeatureException {
        if (!supportsEncryptionOf(zipArchiveEntry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, zipArchiveEntry);
        } else if (!supportsMethodOf(zipArchiveEntry)) {
            ZipMethod methodByCode = ZipMethod.getMethodByCode(zipArchiveEntry.getMethod());
            if (methodByCode == null) {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, zipArchiveEntry);
            }
            throw new UnsupportedZipFeatureException(methodByCode, zipArchiveEntry);
        }
    }

    public static byte[] copy(byte[] bArr) {
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    public static long dosToJavaTime(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, ((int) ((j11 >> 25) & 127)) + 1980);
        instance.set(2, ((int) ((j11 >> 21) & 15)) - 1);
        instance.set(5, ((int) (j11 >> 16)) & 31);
        instance.set(11, ((int) (j11 >> 11)) & 31);
        instance.set(12, ((int) (j11 >> 5)) & 63);
        instance.set(13, ((int) (j11 << 1)) & 62);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static Date fromDosTime(ZipLong zipLong) {
        return new Date(dosToJavaTime(zipLong.getValue()));
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField abstractUnicodeExtraField, byte[] bArr) {
        if (abstractUnicodeExtraField == null) {
            return null;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        if (crc32.getValue() != abstractUnicodeExtraField.getNameCRC32()) {
            return null;
        }
        try {
            return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(abstractUnicodeExtraField.getUnicodeName());
        } catch (IOException unused) {
            return null;
        }
    }

    public static BigInteger longToBig(long j11) {
        int i11 = (j11 > -2147483648L ? 1 : (j11 == -2147483648L ? 0 : -1));
        if (i11 >= 0) {
            if (j11 < 0 && i11 >= 0) {
                j11 = adjustToLong((int) j11);
            }
            return BigInteger.valueOf(j11);
        }
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + j11 + "]");
    }

    public static byte[] reverse(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i11 = 0; i11 < bArr.length / 2; i11++) {
            byte b11 = bArr[i11];
            int i12 = length - i11;
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }
        return bArr;
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [org.apache.commons.compress.archivers.zip.ZipExtraField] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setNameAndCommentFromExtraFields(org.apache.commons.compress.archivers.zip.ZipArchiveEntry r3, byte[] r4, byte[] r5) {
        /*
            org.apache.commons.compress.archivers.zip.ZipShort r0 = org.apache.commons.compress.archivers.zip.UnicodePathExtraField.UPATH_ID
            org.apache.commons.compress.archivers.zip.ZipExtraField r0 = r3.getExtraField(r0)
            boolean r1 = r0 instanceof org.apache.commons.compress.archivers.zip.UnicodePathExtraField
            r2 = 0
            if (r1 == 0) goto L_0x000e
            org.apache.commons.compress.archivers.zip.UnicodePathExtraField r0 = (org.apache.commons.compress.archivers.zip.UnicodePathExtraField) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            java.lang.String r4 = getUnicodeStringIfOriginalMatches(r0, r4)
            if (r4 == 0) goto L_0x001d
            r3.setName(r4)
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry$NameSource r4 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.NameSource.UNICODE_EXTRA_FIELD
            r3.setNameSource(r4)
        L_0x001d:
            if (r5 == 0) goto L_0x003d
            int r4 = r5.length
            if (r4 <= 0) goto L_0x003d
            org.apache.commons.compress.archivers.zip.ZipShort r4 = org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField.UCOM_ID
            org.apache.commons.compress.archivers.zip.ZipExtraField r4 = r3.getExtraField(r4)
            boolean r0 = r4 instanceof org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField
            if (r0 == 0) goto L_0x002f
            r2 = r4
            org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField r2 = (org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField) r2
        L_0x002f:
            java.lang.String r4 = getUnicodeStringIfOriginalMatches(r2, r5)
            if (r4 == 0) goto L_0x003d
            r3.setComment(r4)
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry$CommentSource r4 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD
            r3.setCommentSource(r4)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipUtil.setNameAndCommentFromExtraFields(org.apache.commons.compress.archivers.zip.ZipArchiveEntry, byte[], byte[]):void");
    }

    public static int signedByteToUnsignedInt(byte b11) {
        return b11 >= 0 ? b11 : b11 + 256;
    }

    private static boolean supportsEncryptionOf(ZipArchiveEntry zipArchiveEntry) {
        return !zipArchiveEntry.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getMethod() == 0 || zipArchiveEntry.getMethod() == ZipMethod.UNSHRINKING.getCode() || zipArchiveEntry.getMethod() == ZipMethod.IMPLODING.getCode() || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || zipArchiveEntry.getMethod() == ZipMethod.BZIP2.getCode()) {
            return true;
        }
        return false;
    }

    public static ZipLong toDosTime(Date date) {
        return new ZipLong(toDosTime(date.getTime()));
    }

    public static byte unsignedIntToSignedByte(int i11) {
        if (i11 <= 255 && i11 >= 0) {
            return i11 < 128 ? (byte) i11 : (byte) (i11 + InputDeviceCompat.SOURCE_ANY);
        }
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i11 + "]");
    }

    public static void copy(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, i11, bArr.length);
        }
    }

    public static byte[] toDosTime(long j11) {
        byte[] bArr = new byte[4];
        toDosTime(j11, bArr, 0);
        return bArr;
    }

    public static void toDosTime(long j11, byte[] bArr, int i11) {
        toDosTime(Calendar.getInstance(), j11, bArr, i11);
    }

    public static void toDosTime(Calendar calendar, long j11, byte[] bArr, int i11) {
        calendar.setTimeInMillis(j11);
        int i12 = calendar.get(1);
        if (i12 < 1980) {
            copy(DOS_TIME_MIN, bArr, i11);
            return;
        }
        ZipLong.putLong((long) ((calendar.get(13) >> 1) | ((i12 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5)), bArr, i11);
    }
}
