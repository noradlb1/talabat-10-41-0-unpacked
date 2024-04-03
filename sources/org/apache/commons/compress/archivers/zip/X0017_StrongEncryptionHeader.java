package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

public class X0017_StrongEncryptionHeader extends PKWareExtraHeader {
    private PKWareExtraHeader.EncryptionAlgorithm algId;
    private int bitlen;
    private byte[] erdData;
    private int flags;
    private int format;
    private PKWareExtraHeader.HashAlgorithm hashAlg;
    private int hashSize;
    private byte[] ivData;
    private byte[] keyBlob;
    private long rcount;
    private byte[] recipientKeyHash;
    private byte[] vCRC32;
    private byte[] vData;

    public X0017_StrongEncryptionHeader() {
        super(new ZipShort(23));
    }

    private void assertDynamicLengthFits(String str, int i11, int i12, int i13) throws ZipException {
        if (i12 + i11 > i13) {
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: " + str + " " + i11 + " doesn't fit into " + i13 + " bytes of data at position " + i12);
        }
    }

    public PKWareExtraHeader.EncryptionAlgorithm getEncryptionAlgorithm() {
        return this.algId;
    }

    public PKWareExtraHeader.HashAlgorithm getHashAlgorithm() {
        return this.hashAlg;
    }

    public long getRecordCount() {
        return this.rcount;
    }

    public void parseCentralDirectoryFormat(byte[] bArr, int i11, int i12) throws ZipException {
        assertMinimalLength(12, i12);
        this.format = ZipShort.getValue(bArr, i11);
        this.algId = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 2));
        this.bitlen = ZipShort.getValue(bArr, i11 + 4);
        this.flags = ZipShort.getValue(bArr, i11 + 6);
        long value = ZipLong.getValue(bArr, i11 + 8);
        this.rcount = value;
        if (value > 0) {
            assertMinimalLength(16, i12);
            this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 12));
            this.hashSize = ZipShort.getValue(bArr, i11 + 14);
        }
    }

    public void parseFileFormat(byte[] bArr, int i11, int i12) throws ZipException {
        assertMinimalLength(4, i12);
        int value = ZipShort.getValue(bArr, i11);
        assertDynamicLengthFits("ivSize", value, 4, i12);
        int i13 = i11 + 4;
        assertMinimalLength(i13, value);
        this.ivData = Arrays.copyOfRange(bArr, i13, value);
        int i14 = value + 16;
        assertMinimalLength(i14, i12);
        int i15 = i11 + value;
        this.format = ZipShort.getValue(bArr, i15 + 6);
        this.algId = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i15 + 8));
        this.bitlen = ZipShort.getValue(bArr, i15 + 10);
        this.flags = ZipShort.getValue(bArr, i15 + 12);
        int value2 = ZipShort.getValue(bArr, i15 + 14);
        assertDynamicLengthFits("erdSize", value2, i14, i12);
        int i16 = i15 + 16;
        assertMinimalLength(i16, value2);
        this.erdData = Arrays.copyOfRange(bArr, i16, value2);
        int i17 = value + 20 + value2;
        assertMinimalLength(i17, i12);
        long value3 = ZipLong.getValue(bArr, i16 + value2);
        this.rcount = value3;
        if (value3 == 0) {
            assertMinimalLength(i17 + 2, i12);
            int value4 = ZipShort.getValue(bArr, i15 + 20 + value2);
            assertDynamicLengthFits("vSize", value4, value + 22 + value2, i12);
            if (value4 >= 4) {
                int i18 = i15 + 22 + value2;
                int i19 = value4 - 4;
                assertMinimalLength(i18, i19);
                this.vData = Arrays.copyOfRange(bArr, i18, i19);
                int i21 = (i18 + value4) - 4;
                assertMinimalLength(i21, 4);
                this.vCRC32 = Arrays.copyOfRange(bArr, i21, 4);
                return;
            }
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + value4 + " is too small to hold CRC");
        }
        assertMinimalLength(i17 + 6, i12);
        this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i15 + 20 + value2));
        int i22 = i15 + 22 + value2;
        this.hashSize = ZipShort.getValue(bArr, i22);
        int i23 = i15 + 24 + value2;
        int value5 = ZipShort.getValue(bArr, i23);
        int i24 = this.hashSize;
        if (value5 >= i24) {
            this.recipientKeyHash = new byte[i24];
            this.keyBlob = new byte[(value5 - i24)];
            assertDynamicLengthFits("resize", value5, value + 24 + value2, i12);
            System.arraycopy(bArr, i23, this.recipientKeyHash, 0, this.hashSize);
            int i25 = this.hashSize;
            System.arraycopy(bArr, i23 + i25, this.keyBlob, 0, value5 - i25);
            assertMinimalLength(value + 26 + value2 + value5 + 2, i12);
            int value6 = ZipShort.getValue(bArr, i15 + 26 + value2 + value5);
            if (value6 >= 4) {
                assertDynamicLengthFits("vSize", value6, value + 22 + value2 + value5, i12);
                int i26 = value6 - 4;
                byte[] bArr2 = new byte[i26];
                this.vData = bArr2;
                this.vCRC32 = new byte[4];
                int i27 = i22 + value5;
                System.arraycopy(bArr, i27, bArr2, 0, i26);
                System.arraycopy(bArr, (i27 + value6) - 4, this.vCRC32, 0, 4);
                return;
            }
            throw new ZipException("Invalid X0017_StrongEncryptionHeader: vSize " + value6 + " is too small to hold CRC");
        }
        throw new ZipException("Invalid X0017_StrongEncryptionHeader: resize " + value5 + " is too small to hold hashSize" + this.hashSize);
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        super.parseFromCentralDirectoryData(bArr, i11, i12);
        parseCentralDirectoryFormat(bArr, i11, i12);
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        super.parseFromLocalFileData(bArr, i11, i12);
        parseFileFormat(bArr, i11, i12);
    }
}
