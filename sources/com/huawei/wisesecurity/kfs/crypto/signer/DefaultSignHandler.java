package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.codec.Decoder;
import com.huawei.wisesecurity.kfs.crypto.codec.Encoder;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;

public class DefaultSignHandler implements SignHandler {
    public final Key key;
    public final AlgorithmParameterSpec parameterSpec;
    public final SignText signText;

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public DefaultSignHandler(Key key2, SignText signText2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.key = key2;
        this.parameterSpec = algorithmParameterSpec;
        this.signText = signText2;
    }

    private void doAsymmSign() throws CryptoException {
        try {
            Signature instance = Signature.getInstance(this.signText.getAlgId().getTransformation());
            AlgorithmParameterSpec algorithmParameterSpec = this.parameterSpec;
            if (algorithmParameterSpec != null) {
                instance.setParameter(algorithmParameterSpec);
            }
            Key key2 = this.key;
            if (key2 instanceof PrivateKey) {
                instance.initSign((PrivateKey) key2);
                instance.update(this.signText.getDataBytes());
                this.signText.setSignature(instance.sign());
                return;
            }
            throw new CryptoException("sign key not private key");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e11) {
            throw new CryptoException("Fail to sign : " + e11.getMessage());
        }
    }

    private void doSign() throws CryptoException {
        int ordinal = this.signText.getAlgId().ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            doAsymmSign();
        } else if (ordinal == 4) {
            doSymmSign();
        } else {
            throw new CryptoException("unsupported sign alg : " + this.signText.getAlgId().getTransformation());
        }
    }

    private void doSymmSign() throws CryptoException {
        try {
            Mac instance = Mac.getInstance(this.signText.getAlgId().getTransformation());
            instance.init(this.key);
            instance.update(this.signText.getDataBytes());
            this.signText.setSignature(instance.doFinal());
        } catch (InvalidKeyException | NoSuchAlgorithmException e11) {
            throw new CryptoException("Fail to sign : " + e11.getMessage());
        }
    }

    private DefaultSignHandler from(String str, Decoder decoder) throws CryptoException {
        try {
            from(decoder.decode(str));
            return this;
        } catch (CodecException e11) {
            throw new CryptoException("Fail to decode plain text : " + e11.getMessage());
        }
    }

    private String sign(Encoder encoder) throws CryptoException {
        try {
            doSign();
            return encoder.encode(this.signText.getSignature());
        } catch (CodecException e11) {
            throw new CryptoException("Fail to encode signature bytes: " + e11.getMessage());
        }
    }

    public DefaultSignHandler from(String str) throws CryptoException {
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    public DefaultSignHandler from(byte[] bArr) throws CryptoException {
        this.signText.setDataBytes(ByteUtil.clone(bArr));
        return this;
    }

    public DefaultSignHandler fromBase64(String str) throws CryptoException {
        return from(str, Decoder.BASE64);
    }

    public DefaultSignHandler fromBase64Url(String str) throws CryptoException {
        return from(str, Decoder.BASE64Url);
    }

    public DefaultSignHandler fromHex(String str) throws CryptoException {
        return from(str, Decoder.HEX);
    }

    public byte[] sign() throws CryptoException {
        doSign();
        return this.signText.getSignature();
    }

    public String signBase64() throws CryptoException {
        return sign(Encoder.BASE64);
    }

    public String signBase64Url() throws CryptoException {
        return sign(Encoder.BASE64Url);
    }

    public String signHex() throws CryptoException {
        return sign(Encoder.HEX);
    }
}
