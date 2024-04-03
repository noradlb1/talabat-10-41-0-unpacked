package com.huawei.hms.analytics.core.crypto;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.SecureRandom;

public final class RandomUtil {

    /* renamed from: a  reason: collision with root package name */
    private static RandomUtil f47906a;

    /* renamed from: b  reason: collision with root package name */
    private final SecureRandom f47907b;

    private RandomUtil() {
        try {
            EncryptUtil.setBouncycastleFlag(false);
        } catch (Throwable th2) {
            HiLog.w(com.huawei.wisesecurity.kfs.util.RandomUtil.TAG, "setBouncycastleFlag exception. " + th2.getMessage());
        }
        this.f47907b = EncryptUtil.genSecureRandom();
    }

    private static synchronized void a() {
        synchronized (RandomUtil.class) {
            if (f47906a == null) {
                f47906a = new RandomUtil();
            }
        }
    }

    public static RandomUtil getInstance() {
        if (f47906a == null) {
            a();
        }
        return f47906a;
    }

    public final byte[] generateSecureRandom(int i11) {
        byte[] bArr = new byte[i11];
        this.f47907b.nextBytes(bArr);
        return bArr;
    }

    public final String generateSecureRandomStr(int i11) {
        byte[] bArr = new byte[i11];
        this.f47907b.nextBytes(bArr);
        return HAHexUtil.byteArray2HexString(bArr);
    }
}
