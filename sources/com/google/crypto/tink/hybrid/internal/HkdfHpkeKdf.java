package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Immutable
final class HkdfHpkeKdf implements HpkeKdf {
    private final String macAlgorithm;

    public HkdfHpkeKdf(String str) {
        this.macAlgorithm = str;
    }

    private byte[] expand(byte[] bArr, byte[] bArr2, int i11) throws GeneralSecurityException {
        Mac instance = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (i11 <= instance.getMacLength() * 255) {
            byte[] bArr3 = new byte[i11];
            instance.init(new SecretKeySpec(bArr, this.macAlgorithm));
            byte[] bArr4 = new byte[0];
            int i12 = 1;
            int i13 = 0;
            while (true) {
                instance.update(bArr4);
                instance.update(bArr2);
                instance.update((byte) i12);
                bArr4 = instance.doFinal();
                if (bArr4.length + i13 < i11) {
                    System.arraycopy(bArr4, 0, bArr3, i13, bArr4.length);
                    i13 += bArr4.length;
                    i12++;
                } else {
                    System.arraycopy(bArr4, 0, bArr3, i13, i11 - i13);
                    return bArr3;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }

    private byte[] extract(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac instance = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (bArr2 == null || bArr2.length == 0) {
            instance.init(new SecretKeySpec(new byte[instance.getMacLength()], this.macAlgorithm));
        } else {
            instance.init(new SecretKeySpec(bArr2, this.macAlgorithm));
        }
        return instance.doFinal(bArr);
    }

    public byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i11) throws GeneralSecurityException {
        return expand(extract(HpkeUtil.labelIkm(str, bArr2, bArr4), bArr), HpkeUtil.labelInfo(str2, bArr3, bArr4, i11), i11);
    }

    public byte[] getKdfId() throws GeneralSecurityException {
        String str = this.macAlgorithm;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 984523022:
                if (str.equals("HmacSha256")) {
                    c11 = 0;
                    break;
                }
                break;
            case 984524074:
                if (str.equals("HmacSha384")) {
                    c11 = 1;
                    break;
                }
                break;
            case 984525777:
                if (str.equals("HmacSha512")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return HpkeUtil.HKDF_SHA256_KDF_ID;
            case 1:
                return HpkeUtil.HKDF_SHA384_KDF_ID;
            case 2:
                return HpkeUtil.HKDF_SHA512_KDF_ID;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    public int getMacLength() throws GeneralSecurityException {
        return Mac.getInstance(this.macAlgorithm).getMacLength();
    }

    public byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i11) throws GeneralSecurityException {
        return expand(bArr, HpkeUtil.labelInfo(str, bArr2, bArr3, i11), i11);
    }

    public byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return extract(HpkeUtil.labelIkm(str, bArr2, bArr3), bArr);
    }
}
