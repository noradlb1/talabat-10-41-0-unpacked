package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

@Immutable
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType, Enums.HashType hashType2, int i11) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            Validators.validateSignatureHash(hashType);
            Validators.validateRsaModulusSize(rSAPrivateCrtKey.getModulus().bitLength());
            Validators.validateRsaPublicExponent(rSAPrivateCrtKey.getPublicExponent());
            this.privateKey = rSAPrivateCrtKey;
            this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
            this.sigHash = hashType;
            this.mgf1Hash = hashType2;
            this.saltLength = i11;
            return;
        }
        throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
    }

    private byte[] emsaPssEncode(byte[] bArr, int i11) throws GeneralSecurityException {
        int i12 = i11;
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = instance.digest(bArr);
        int digestLength = instance.getDigestLength();
        int i13 = ((i12 - 1) / 8) + 1;
        int i14 = this.saltLength;
        if (i13 >= digestLength + i14 + 2) {
            byte[] randBytes = Random.randBytes(i14);
            int i15 = digestLength + 8;
            byte[] bArr2 = new byte[(this.saltLength + i15)];
            System.arraycopy(digest, 0, bArr2, 8, digestLength);
            System.arraycopy(randBytes, 0, bArr2, i15, randBytes.length);
            byte[] digest2 = instance.digest(bArr2);
            int i16 = (i13 - digestLength) - 1;
            byte[] bArr3 = new byte[i16];
            int i17 = this.saltLength;
            bArr3[((i13 - i17) - digestLength) - 2] = 1;
            System.arraycopy(randBytes, 0, bArr3, ((i13 - i17) - digestLength) - 1, randBytes.length);
            byte[] mgf1 = SubtleUtil.mgf1(digest2, i16, this.mgf1Hash);
            byte[] bArr4 = new byte[i16];
            for (int i18 = 0; i18 < i16; i18++) {
                bArr4[i18] = (byte) (bArr3[i18] ^ mgf1[i18]);
            }
            for (int i19 = 0; ((long) i19) < (((long) i13) * 8) - ((long) i12); i19++) {
                int i21 = i19 / 8;
                bArr4[i21] = (byte) ((~(1 << (7 - (i19 % 8)))) & bArr4[i21]);
            }
            int i22 = digestLength + i16;
            byte[] bArr5 = new byte[(i22 + 1)];
            System.arraycopy(bArr4, 0, bArr5, 0, i16);
            System.arraycopy(digest2, 0, bArr5, i16, digest2.length);
            bArr5[i22] = -68;
            return bArr5;
        }
        throw new GeneralSecurityException("encoding error");
    }

    private byte[] rsasp1(byte[] bArr) throws GeneralSecurityException {
        EngineFactory<EngineWrapper.TCipher, Cipher> engineFactory = EngineFactory.CIPHER;
        Cipher instance = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        instance.init(2, this.privateKey);
        byte[] doFinal = instance.doFinal(bArr);
        Cipher instance2 = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        instance2.init(1, this.publicKey);
        if (new BigInteger(1, bArr).equals(new BigInteger(1, instance2.doFinal(doFinal)))) {
            return doFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        return rsasp1(emsaPssEncode(bArr, this.publicKey.getModulus().bitLength() - 1));
    }
}
