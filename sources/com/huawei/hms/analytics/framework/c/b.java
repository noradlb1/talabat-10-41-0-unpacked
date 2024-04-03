package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.crypto.AesCipher;
import com.huawei.hms.analytics.framework.config.IMandatoryParameters;

public final class b {

    /* renamed from: com.huawei.hms.analytics.framework.c.b$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47963a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.huawei.hms.analytics.framework.config.CipherType[] r0 = com.huawei.hms.analytics.framework.config.CipherType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47963a = r0
                com.huawei.hms.analytics.framework.config.CipherType r1 = com.huawei.hms.analytics.framework.config.CipherType.AESGCM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f47963a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.analytics.framework.config.CipherType r1 = com.huawei.hms.analytics.framework.config.CipherType.AESCBC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.framework.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    public static String a(String str) {
        IMandatoryParameters iMandatoryParameters = com.huawei.hms.analytics.framework.b.b.a().f47924a;
        if (iMandatoryParameters == null) {
            return "";
        }
        String loadWorkKey = iMandatoryParameters.getLoadWorkKey();
        int i11 = AnonymousClass1.f47963a[iMandatoryParameters.getCipherType().ordinal()];
        return i11 != 1 ? i11 != 2 ? "" : AesCipher.encryptCbc(str, loadWorkKey) : AesCipher.gcmEncrypt(str, loadWorkKey);
    }

    public static String a(String str, IMandatoryParameters iMandatoryParameters) {
        if (iMandatoryParameters == null) {
            return "";
        }
        int i11 = AnonymousClass1.f47963a[iMandatoryParameters.getCipherType().ordinal()];
        return i11 != 1 ? i11 != 2 ? "" : AesCipher.decryptCbc(str, iMandatoryParameters.getLoadWorkKey()) : AesCipher.gcmDecrypt(str, iMandatoryParameters.getLoadWorkKey());
    }
}
