package org.apache.commons.compress.archivers.zip;

public final class GeneralPurposeBit implements Cloneable {
    private static final int DATA_DESCRIPTOR_FLAG = 8;
    private static final int ENCRYPTION_FLAG = 1;
    private static final int NUMBER_OF_SHANNON_FANO_TREES_FLAG = 4;
    private static final int SLIDING_DICTIONARY_SIZE_FLAG = 2;
    private static final int STRONG_ENCRYPTION_FLAG = 64;
    public static final int UFT8_NAMES_FLAG = 2048;
    private boolean dataDescriptorFlag;
    private boolean encryptionFlag;
    private boolean languageEncodingFlag;
    private int numberOfShannonFanoTrees;
    private int slidingDictionarySize;
    private boolean strongEncryptionFlag;

    public static GeneralPurposeBit parse(byte[] bArr, int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i12;
        int i13;
        int value = ZipShort.getValue(bArr, i11);
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        boolean z14 = false;
        if ((value & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        generalPurposeBit.useDataDescriptor(z11);
        if ((value & 2048) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        generalPurposeBit.useUTF8ForNames(z12);
        if ((value & 64) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        generalPurposeBit.useStrongEncryption(z13);
        if ((value & 1) != 0) {
            z14 = true;
        }
        generalPurposeBit.useEncryption(z14);
        if ((value & 2) != 0) {
            i12 = 8192;
        } else {
            i12 = 4096;
        }
        generalPurposeBit.slidingDictionarySize = i12;
        if ((value & 4) != 0) {
            i13 = 3;
        } else {
            i13 = 2;
        }
        generalPurposeBit.numberOfShannonFanoTrees = i13;
        return generalPurposeBit;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e11);
        }
    }

    public byte[] encode() {
        byte[] bArr = new byte[2];
        encode(bArr, 0);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeneralPurposeBit)) {
            return false;
        }
        GeneralPurposeBit generalPurposeBit = (GeneralPurposeBit) obj;
        if (generalPurposeBit.encryptionFlag == this.encryptionFlag && generalPurposeBit.strongEncryptionFlag == this.strongEncryptionFlag && generalPurposeBit.languageEncodingFlag == this.languageEncodingFlag && generalPurposeBit.dataDescriptorFlag == this.dataDescriptorFlag) {
            return true;
        }
        return false;
    }

    public int getNumberOfShannonFanoTrees() {
        return this.numberOfShannonFanoTrees;
    }

    public int getSlidingDictionarySize() {
        return this.slidingDictionarySize;
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * true) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public void useDataDescriptor(boolean z11) {
        this.dataDescriptorFlag = z11;
    }

    public void useEncryption(boolean z11) {
        this.encryptionFlag = z11;
    }

    public void useStrongEncryption(boolean z11) {
        this.strongEncryptionFlag = z11;
        if (z11) {
            useEncryption(true);
        }
    }

    public void useUTF8ForNames(boolean z11) {
        this.languageEncodingFlag = z11;
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public boolean usesStrongEncryption() {
        return this.encryptionFlag && this.strongEncryptionFlag;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }

    public void encode(byte[] bArr, int i11) {
        char c11 = 0;
        boolean z11 = (this.dataDescriptorFlag ? (char) 8 : 0) | (this.languageEncodingFlag ? (char) 2048 : 0) | this.encryptionFlag;
        if (this.strongEncryptionFlag) {
            c11 = '@';
        }
        ZipShort.putShort(z11 | c11 ? 1 : 0, bArr, i11);
    }
}
