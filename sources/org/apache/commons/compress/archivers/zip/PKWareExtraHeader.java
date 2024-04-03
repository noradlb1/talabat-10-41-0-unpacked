package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

public abstract class PKWareExtraHeader implements ZipExtraField {
    private byte[] centralData;
    private final ZipShort headerId;
    private byte[] localData;

    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(65535);
        
        private static final Map<Integer, EncryptionAlgorithm> codeToEnum = null;
        private final int code;

        /* access modifiers changed from: public */
        static {
            int i11;
            HashMap hashMap = new HashMap();
            for (EncryptionAlgorithm encryptionAlgorithm : values()) {
                hashMap.put(Integer.valueOf(encryptionAlgorithm.getCode()), encryptionAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        private EncryptionAlgorithm(int i11) {
            this.code = i11;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int i11) {
            return codeToEnum.get(Integer.valueOf(i11));
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);
        
        private static final Map<Integer, HashAlgorithm> codeToEnum = null;
        private final int code;

        /* access modifiers changed from: public */
        static {
            int i11;
            HashMap hashMap = new HashMap();
            for (HashAlgorithm hashAlgorithm : values()) {
                hashMap.put(Integer.valueOf(hashAlgorithm.getCode()), hashAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        private HashAlgorithm(int i11) {
            this.code = i11;
        }

        public static HashAlgorithm getAlgorithmByCode(int i11) {
            return codeToEnum.get(Integer.valueOf(i11));
        }

        public int getCode() {
            return this.code;
        }
    }

    public PKWareExtraHeader(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public final void assertMinimalLength(int i11, int i12) throws ZipException {
        if (i12 < i11) {
            throw new ZipException(getClass().getName() + " is too short, only " + i12 + " bytes, expected at least " + i11);
        }
    }

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

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
        setCentralDirectoryData(copyOfRange);
        if (this.localData == null) {
            setLocalFileDataData(copyOfRange);
        }
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        setLocalFileDataData(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.centralData = ZipUtil.copy(bArr);
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.localData = ZipUtil.copy(bArr);
    }
}
