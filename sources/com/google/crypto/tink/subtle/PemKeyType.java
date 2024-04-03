package com.google.crypto.tink.subtle;

import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.crypto.tink.subtle.Enums;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.annotation.Nullable;

@Deprecated
public enum PemKeyType {
    RSA_PSS_2048_SHA256("RSA", "RSASSA-PSS", 2048, r15),
    RSA_PSS_3072_SHA256("RSA", "RSASSA-PSS", KfsConstant.KFS_RSA_KEY_LEN_3072, r14),
    RSA_PSS_4096_SHA256("RSA", "RSASSA-PSS", 4096, r14),
    RSA_PSS_4096_SHA512("RSA", "RSASSA-PSS", 4096, r3),
    RSA_SIGN_PKCS1_2048_SHA256("RSA", "RSASSA-PKCS1-v1_5", 2048, r14),
    RSA_SIGN_PKCS1_3072_SHA256("RSA", "RSASSA-PKCS1-v1_5", KfsConstant.KFS_RSA_KEY_LEN_3072, r14),
    RSA_SIGN_PKCS1_4096_SHA256("RSA", "RSASSA-PKCS1-v1_5", 4096, r14),
    RSA_SIGN_PKCS1_4096_SHA512("RSA", "RSASSA-PKCS1-v1_5", 4096, r3),
    ECDSA_P256_SHA256("EC", "ECDSA", 256, r15),
    ECDSA_P384_SHA384("EC", "ECDSA", RendererCapabilities.MODE_SUPPORT_MASK, Enums.HashType.SHA384),
    ECDSA_P521_SHA512("EC", "ECDSA", 521, r3);
    
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";
    private static final String MARKER = "-----";
    private static final String PRIVATE_KEY = "PRIVATE KEY";
    private static final String PUBLIC_KEY = "PUBLIC KEY";
    public final String algorithm;
    public final Enums.HashType hash;
    public final int keySizeInBits;
    public final String keyType;

    private PemKeyType(String str, String str2, int i11, Enums.HashType hashType) {
        this.keyType = str;
        this.algorithm = str2;
        this.keySizeInBits = i11;
        this.hash = hashType;
    }

    private Key getPrivateKey(byte[] bArr) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePrivate(new PKCS8EncodedKeySpec(bArr)));
    }

    private Key getPublicKey(byte[] bArr) throws GeneralSecurityException {
        return validate(EngineFactory.KEY_FACTORY.getInstance(this.keyType).generatePublic(new X509EncodedKeySpec(bArr)));
    }

    private Key validate(Key key) throws GeneralSecurityException {
        if (this.keyType.equals("RSA")) {
            int bitLength = ((RSAKey) key).getModulus().bitLength();
            if (bitLength != this.keySizeInBits) {
                throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(bitLength)}));
            }
        } else {
            ECParameterSpec params = ((ECKey) key).getParams();
            if (EllipticCurves.isNistEcParameterSpec(params)) {
                int fieldSizeInBits = EllipticCurves.fieldSizeInBits(params.getCurve());
                if (fieldSizeInBits != this.keySizeInBits) {
                    throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(fieldSizeInBits)}));
                }
            } else {
                throw new GeneralSecurityException("unsupport EC spec: " + params.toString());
            }
        }
        return key;
    }

    @Nullable
    public Key readKey(BufferedReader bufferedReader) throws IOException {
        String substring;
        int indexOf;
        String readLine = bufferedReader.readLine();
        while (readLine != null && !readLine.startsWith(BEGIN)) {
            readLine = bufferedReader.readLine();
        }
        if (readLine == null || (indexOf = substring.indexOf(MARKER)) < 0) {
            return null;
        }
        String substring2 = (substring = readLine.trim().substring(11)).substring(0, indexOf);
        String str = END + substring2 + MARKER;
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                if (readLine2.indexOf(CertificateUtil.DELIMITER) <= 0) {
                    if (!readLine2.contains(str)) {
                        sb2.append(readLine2);
                    }
                }
            }
            try {
                byte[] decode = Base64.decode(sb2.toString(), 0);
                if (substring2.contains(PUBLIC_KEY)) {
                    return getPublicKey(decode);
                }
                if (substring2.contains(PRIVATE_KEY)) {
                    return getPrivateKey(decode);
                }
                return null;
            } catch (IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
    }
}
