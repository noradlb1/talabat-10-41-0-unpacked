package com.google.crypto.tink.subtle;

import com.adjust.sdk.Constants;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

public final class SubtleUtil {

    /* renamed from: com.google.crypto.tink.subtle.SubtleUtil$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.subtle.Enums$HashType[] r0 = com.google.crypto.tink.subtle.Enums.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA224     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA384     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.SubtleUtil.AnonymousClass1.<clinit>():void");
        }
    }

    private SubtleUtil() {
    }

    @Deprecated
    public static int androidApiLevel() {
        Integer androidApiLevel = Util.getAndroidApiLevel();
        if (androidApiLevel != null) {
            return androidApiLevel.intValue();
        }
        return -1;
    }

    public static BigInteger bytes2Integer(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] integer2Bytes(BigInteger bigInteger, int i11) throws GeneralSecurityException {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i11) {
            return byteArray;
        }
        int i12 = i11 + 1;
        if (byteArray.length > i12) {
            throw new GeneralSecurityException("integer too large");
        } else if (byteArray.length != i12) {
            byte[] bArr = new byte[i11];
            System.arraycopy(byteArray, 0, bArr, i11 - byteArray.length, byteArray.length);
            return bArr;
        } else if (byteArray[0] == 0) {
            return Arrays.copyOfRange(byteArray, 1, byteArray.length);
        } else {
            throw new GeneralSecurityException("integer too large");
        }
    }

    public static boolean isAndroid() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    public static byte[] mgf1(byte[] bArr, int i11, Enums.HashType hashType) throws GeneralSecurityException {
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(toDigestAlgo(hashType));
        int digestLength = instance.getDigestLength();
        byte[] bArr2 = new byte[i11];
        int i12 = 0;
        for (int i13 = 0; i13 <= (i11 - 1) / digestLength; i13++) {
            instance.reset();
            instance.update(bArr);
            instance.update(integer2Bytes(BigInteger.valueOf((long) i13), 4));
            byte[] digest = instance.digest();
            System.arraycopy(digest, 0, bArr2, i12, Math.min(digest.length, i11 - i12));
            i12 += digest.length;
        }
        return bArr2;
    }

    public static void putAsUnsigedInt(ByteBuffer byteBuffer, long j11) throws GeneralSecurityException {
        if (0 > j11 || j11 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBuffer.putInt((int) j11);
    }

    public static String toDigestAlgo(Enums.HashType hashType) throws GeneralSecurityException {
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i11 == 1) {
            return "SHA-1";
        }
        if (i11 == 2) {
            return "SHA-224";
        }
        if (i11 == 3) {
            return Constants.SHA256;
        }
        if (i11 == 4) {
            return "SHA-384";
        }
        if (i11 == 5) {
            return "SHA-512";
        }
        throw new GeneralSecurityException("Unsupported hash " + hashType);
    }

    public static String toEcdsaAlgo(Enums.HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        return hashType + "withECDSA";
    }

    public static String toRsaSsaPkcs1Algo(Enums.HashType hashType) throws GeneralSecurityException {
        Validators.validateSignatureHash(hashType);
        return hashType + "withRSA";
    }
}
