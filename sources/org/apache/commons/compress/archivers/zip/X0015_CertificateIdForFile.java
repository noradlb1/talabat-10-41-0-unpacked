package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

public class X0015_CertificateIdForFile extends PKWareExtraHeader {
    private PKWareExtraHeader.HashAlgorithm hashAlg;
    private int rcount;

    public X0015_CertificateIdForFile() {
        super(new ZipShort(21));
    }

    public PKWareExtraHeader.HashAlgorithm getHashAlgorithm() {
        return this.hashAlg;
    }

    public int getRecordCount() {
        return this.rcount;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        assertMinimalLength(4, i12);
        super.parseFromCentralDirectoryData(bArr, i11, i12);
        this.rcount = ZipShort.getValue(bArr, i11);
        this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 2));
    }
}
