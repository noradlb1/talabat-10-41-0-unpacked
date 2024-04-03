package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

@Immutable
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i11) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            Validators.validateSignatureHash(hashType);
            Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
            Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
            this.publicKey = rSAPublicKey;
            this.sigHash = hashType;
            this.mgf1Hash = hashType2;
            this.saltLength = i11;
            return;
        }
        throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
    }

    private void emsaPssVerify(byte[] bArr, byte[] bArr2, int i11) throws GeneralSecurityException {
        byte[] bArr3 = bArr2;
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = instance.digest(bArr);
        int digestLength = instance.getDigestLength();
        int length = bArr3.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        } else if (bArr3[bArr3.length - 1] == -68) {
            int i12 = length - digestLength;
            int i13 = i12 - 1;
            byte[] copyOf = Arrays.copyOf(bArr3, i13);
            byte[] copyOfRange = Arrays.copyOfRange(bArr3, copyOf.length, copyOf.length + digestLength);
            int i14 = 0;
            while (true) {
                int i15 = i13;
                MessageDigest messageDigest = instance;
                byte[] bArr4 = digest;
                long j11 = (((long) length) * 8) - ((long) i11);
                if (((long) i14) < j11) {
                    if (((copyOf[i14 / 8] >> (7 - (i14 % 8))) & 1) == 0) {
                        i14++;
                        i13 = i15;
                        instance = messageDigest;
                        digest = bArr4;
                    } else {
                        throw new GeneralSecurityException("inconsistent");
                    }
                } else {
                    byte[] mgf1 = SubtleUtil.mgf1(copyOfRange, i15, this.mgf1Hash);
                    int length2 = mgf1.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i16 = 0; i16 < length2; i16++) {
                        bArr5[i16] = (byte) (mgf1[i16] ^ copyOf[i16]);
                    }
                    for (int i17 = 0; ((long) i17) <= j11; i17++) {
                        int i18 = i17 / 8;
                        bArr5[i18] = (byte) ((~(1 << (7 - (i17 % 8)))) & bArr5[i18]);
                    }
                    int i19 = 0;
                    while (true) {
                        int i21 = this.saltLength;
                        if (i19 < (i12 - i21) - 2) {
                            if (bArr5[i19] == 0) {
                                i19++;
                            } else {
                                throw new GeneralSecurityException("inconsistent");
                            }
                        } else if (bArr5[(i12 - i21) - 2] == 1) {
                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr5, length2 - i21, length2);
                            int i22 = digestLength + 8;
                            byte[] bArr6 = new byte[(this.saltLength + i22)];
                            byte[] bArr7 = bArr4;
                            System.arraycopy(bArr7, 0, bArr6, 8, bArr7.length);
                            System.arraycopy(copyOfRange2, 0, bArr6, i22, copyOfRange2.length);
                            if (!Bytes.equal(messageDigest.digest(bArr6), copyOfRange)) {
                                throw new GeneralSecurityException("inconsistent");
                            }
                            return;
                        } else {
                            throw new GeneralSecurityException("inconsistent");
                        }
                    }
                }
            }
        } else {
            throw new GeneralSecurityException("inconsistent");
        }
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        int bitLength2 = ((modulus.bitLength() - 1) + 7) / 8;
        if (bitLength == bArr.length) {
            BigInteger bytes2Integer = SubtleUtil.bytes2Integer(bArr);
            if (bytes2Integer.compareTo(modulus) < 0) {
                emsaPssVerify(bArr2, SubtleUtil.integer2Bytes(bytes2Integer.modPow(publicExponent, modulus), bitLength2), modulus.bitLength() - 1);
                return;
            }
            throw new GeneralSecurityException("signature out of range");
        }
        throw new GeneralSecurityException("invalid signature's length");
    }
}
