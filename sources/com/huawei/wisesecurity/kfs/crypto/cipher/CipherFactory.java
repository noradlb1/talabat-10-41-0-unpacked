package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.crypto.cipher.rsa.RSACipher;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class CipherFactory {

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.cipher.CipherFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg;

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
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg[] r0 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg = r0
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg     // Catch:{ NoSuchFieldError -> 0x0013 }
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg r1 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0013 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0013 }
            L_0x0013:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg     // Catch:{ NoSuchFieldError -> 0x001a }
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg r1 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001a }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001a }
            L_0x001a:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg     // Catch:{ NoSuchFieldError -> 0x0021 }
                com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg r1 = com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0021 }
                r1 = 4
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.kfs.crypto.cipher.CipherFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public static KfsCipher getCipher(CipherAlg cipherAlg, Key key, byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec) throws CryptoException {
        int ordinal = cipherAlg.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            return new AESCipher.Builder().withAlg(cipherAlg).withKey(key).withIv(bArr).build();
        }
        if (ordinal == 4) {
            return (KfsCipher) new RSACipher.Builder().withAlg(cipherAlg).withKey(key).withParameterSpec(algorithmParameterSpec).build();
        }
        throw new CryptoException("unsupported alg : " + cipherAlg.getTransformation());
    }
}
