package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.signer.ec.ECSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.hmac.HmacSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.rsa.RSASigner;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class SignerFactory {

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.signer.SignerFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001a */
        static {
            /*
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg[] r0 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg = r0
                r1 = 1
                r2 = 2
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000d }
            L_0x000d:
                r0 = 3
                int[] r3 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg r4 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0014 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r2 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg     // Catch:{ NoSuchFieldError -> 0x001a }
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg r3 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001a }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001a }
            L_0x001a:
                int[] r0 = $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg     // Catch:{ NoSuchFieldError -> 0x0021 }
                com.huawei.wisesecurity.kfs.crypto.signer.SignAlg r1 = com.huawei.wisesecurity.kfs.crypto.signer.SignAlg.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0021 }
                r1 = 4
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.kfs.crypto.signer.SignerFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public static KfsSigner getSigner(SignAlg signAlg, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws CryptoException {
        int ordinal = signAlg.ordinal();
        if (ordinal == 1) {
            return (KfsSigner) new ECSigner.Builder().withAlg(signAlg).withKey(key).build();
        }
        if (ordinal == 2 || ordinal == 3) {
            return (KfsSigner) new RSASigner.Builder().withAlg(signAlg).withKey(key).withParameterSpec(algorithmParameterSpec).build();
        }
        if (ordinal == 4) {
            return new HmacSigner.Builder().withAlg(signAlg).withKey(key).build();
        }
        throw new CryptoException("unsupported alg : " + signAlg.getTransformation());
    }
}
