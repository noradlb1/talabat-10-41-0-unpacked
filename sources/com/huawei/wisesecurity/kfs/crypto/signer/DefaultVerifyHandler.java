package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;

public class DefaultVerifyHandler implements VerifyHandler {
    public final Key key;
    public final AlgorithmParameterSpec parameterSpec;
    public final SignText signText;

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0013 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
        static {
            /*
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg[] r0 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg = r0
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg     // Catch:{ NoSuchFieldError -> 0x0013 }
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg r1 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0013 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0013 }
            L_0x0013:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg     // Catch:{ NoSuchFieldError -> 0x001a }
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg r1 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001a }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001a }
            L_0x001a:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg     // Catch:{ NoSuchFieldError -> 0x0021 }
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg r1 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0021 }
                r1 = 4
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public DefaultVerifyHandler(Key key2, SignText signText2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.key = key2;
        this.parameterSpec = algorithmParameterSpec;
        this.signText = signText2;
    }

    private boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private boolean doAsymmVerify() throws CryptoException {
        try {
            Signature instance = Signature.getInstance(this.signText.getAlgId().getTransformation());
            AlgorithmParameterSpec algorithmParameterSpec = this.parameterSpec;
            if (algorithmParameterSpec != null) {
                instance.setParameter(algorithmParameterSpec);
            }
            Key key2 = this.key;
            if (key2 instanceof PublicKey) {
                instance.initVerify((PublicKey) key2);
                instance.update(this.signText.getDataBytes());
                return instance.verify(this.signText.getSignature());
            }
            throw new CryptoException("verify key not public key");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e11) {
            throw new CryptoException("Fail to decrypt: " + e11.getMessage());
        }
    }

    private boolean doSymmVerify() throws CryptoException {
        try {
            Mac instance = Mac.getInstance(this.signText.getAlgId().getTransformation());
            instance.init(this.key);
            instance.update(this.signText.getDataBytes());
            return checkSignature(this.signText.getSignature(), instance.doFinal());
        } catch (InvalidKeyException | NoSuchAlgorithmException e11) {
            throw new CryptoException("Fail to sign : " + e11.getMessage());
        }
    }

    private boolean doVerify() throws CryptoException {
        int ordinal = this.signText.getAlgId().ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            return doAsymmVerify();
        }
        if (ordinal == 4) {
            return doSymmVerify();
        }
        throw new CryptoException("unsupported sign alg : " + this.signText.getAlgId().getTransformation());
    }

    private DefaultVerifyHandler fromData(String str, Decoder decoder) throws CryptoException {
        try {
            fromData(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new CryptoException("Fail to decode sign data: " + e11.getMessage());
        }
    }

    private boolean verify(String str, Decoder decoder) throws CryptoException {
        try {
            return verify(decoder.decode(str));
        } catch (CodecException e11) {
            throw new CryptoException("Fail to decode signature : " + e11.getMessage());
        }
    }

    public DefaultVerifyHandler fromBase64Data(String str) throws CryptoException {
        return fromData(str, Decoder.BASE64);
    }

    public DefaultVerifyHandler fromBase64UrlData(String str) throws CryptoException {
        return fromData(str, Decoder.BASE64Url);
    }

    public DefaultVerifyHandler fromData(String str) throws CryptoException {
        return fromData(str.getBytes(Charset.forName("UTF-8")));
    }

    public DefaultVerifyHandler fromData(byte[] bArr) throws CryptoException {
        this.signText.setDataBytes(bArr);
        return this;
    }

    public DefaultVerifyHandler fromHexData(String str) throws CryptoException {
        return fromData(str, Decoder.HEX);
    }

    public boolean verify(String str) throws CryptoException {
        return verify(str.getBytes(Charset.forName("UTF-8")));
    }

    public boolean verify(byte[] bArr) throws CryptoException {
        this.signText.setSignature(bArr);
        return doVerify();
    }

    public boolean verifyBase64(String str) throws CryptoException {
        return verify(str, Decoder.BASE64);
    }

    public boolean verifyBase64Url(String str) throws CryptoException {
        return verify(str, Decoder.BASE64Url);
    }

    public boolean verifyHex(String str) throws CryptoException {
        return verify(str, Decoder.HEX);
    }
}
