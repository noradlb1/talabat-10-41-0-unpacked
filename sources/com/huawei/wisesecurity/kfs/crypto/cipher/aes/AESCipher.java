package com.huawei.wisesecurity.kfs.crypto.cipher.aes;

import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherText;
import com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultDecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultEncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;

public class AESCipher implements KfsCipher {
    public final CipherAlg cipherAlg;
    public final Key key;
    public final AlgorithmParameterSpec parameterSpec;

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
        static {
            /*
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg[] r0 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg = r0
                r1 = 1
                r2 = 3
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000d }
            L_0x000d:
                r0 = 2
                int[] r3 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg r4 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0014 }
                r3[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r1 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg     // Catch:{ NoSuchFieldError -> 0x001a }
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg r3 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001a }
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001a }
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {
        public CipherAlg cipherAlg = CipherAlg.getPreferredAlg("AES");
        public Key key;
        public AlgorithmParameterSpec parameterSpec;

        public AESCipher build() throws CryptoException {
            AlgorithmParameterSpec algorithmParameterSpec;
            Key key2 = this.key;
            if (key2 != null && (algorithmParameterSpec = this.parameterSpec) != null) {
                return new AESCipher(this.cipherAlg, key2, algorithmParameterSpec, (AnonymousClass1) null);
            }
            throw new CryptoException("key | parameterSpec cannot be null");
        }

        public Builder withAlg(CipherAlg cipherAlg2) {
            this.cipherAlg = cipherAlg2;
            return this;
        }

        public Builder withIv(byte[] bArr) throws CryptoException {
            AlgorithmParameterSpec algorithmParameterSpec;
            int ordinal = this.cipherAlg.ordinal();
            if (ordinal == 1 || ordinal == 2) {
                algorithmParameterSpec = new IvParameterSpec(ByteUtil.clone(bArr));
            } else if (ordinal == 3) {
                algorithmParameterSpec = new GCMParameterSpec(128, ByteUtil.clone(bArr));
            } else {
                throw new CryptoException("unsupported cipher alg");
            }
            this.parameterSpec = algorithmParameterSpec;
            return this;
        }

        public Builder withKey(Key key2) {
            this.key = key2;
            return this;
        }

        public Builder withKeyStoreAlias(String str) throws KfsException {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                instance.load((KeyStore.LoadStoreParameter) null);
                this.key = instance.getKey(str, (char[]) null);
                return this;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e11) {
                throw new KfsException("keystore get key with alias failed, " + e11.getMessage());
            }
        }
    }

    public AESCipher(CipherAlg cipherAlg2, Key key2, AlgorithmParameterSpec algorithmParameterSpec) {
        this.cipherAlg = cipherAlg2;
        this.key = key2;
        this.parameterSpec = algorithmParameterSpec;
    }

    public /* synthetic */ AESCipher(CipherAlg cipherAlg2, Key key2, AlgorithmParameterSpec algorithmParameterSpec, AnonymousClass1 r42) {
        this(cipherAlg2, key2, algorithmParameterSpec);
    }

    public DecryptHandler getDecryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        return new DefaultDecryptHandler(this.key, cipherText, this.parameterSpec);
    }

    public EncryptHandler getEncryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        return new DefaultEncryptHandler(this.key, cipherText, this.parameterSpec);
    }
}
