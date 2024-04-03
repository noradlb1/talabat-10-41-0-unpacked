package com.huawei.hms.analytics.framework.b;

import com.huawei.hms.analytics.core.crypto.RandomUtil;
import com.huawei.hms.analytics.core.crypto.RsaCipher;
import java.util.HashMap;
import java.util.Map;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f47934b = new e();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, d> f47935a = new HashMap();

    public static e a() {
        return f47934b;
    }

    public static String a(String str) {
        return b.a().f47924a.getPubKeyVersion(str);
    }

    public static void a(d dVar, String str) {
        byte[] rsaPublicKey = b.a().f47924a.getRsaPublicKey(str);
        if (rsaPublicKey == null || rsaPublicKey.length == 0) {
            throw new IllegalArgumentException("pub key is error");
        }
        String generateSecureRandomStr = RandomUtil.getInstance().generateSecureRandomStr(16);
        String encrypt = RsaCipher.encrypt(rsaPublicKey, generateSecureRandomStr);
        String a11 = a(str);
        long currentTimeMillis = System.currentTimeMillis();
        dVar.f47932d = a11;
        dVar.a(rsaPublicKey);
        dVar.f47930b = encrypt;
        dVar.f47929a = generateSecureRandomStr;
        dVar.f47931c = currentTimeMillis;
    }
}
