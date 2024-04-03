package com.huawei.agconnect.common.api;

import android.text.TextUtils;
import com.huawei.agconnect.credential.obs.h;
import com.huawei.agconnect.datastore.annotation.ICrypto;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.util.HexUtil;
import javax.crypto.SecretKey;

public class AgcCrypto implements ICrypto {
    private static final AgcCrypto INSTANCE = new AgcCrypto();

    public static ICrypto get() {
        return INSTANCE;
    }

    public String decrypt(String str) {
        String decrypt = AesCbc.decrypt(str, getKeyV2());
        if (TextUtils.isEmpty(decrypt)) {
            decrypt = AesCbc.decrypt(str, getKey());
            if (TextUtils.isEmpty(decrypt)) {
                return str;
            }
        }
        return decrypt;
    }

    public String encrypt(String str) {
        return getKeyV2() == null ? str : AesCbc.encrypt(str, getKeyV2());
    }

    public String getKey() {
        return h.f47575a.a();
    }

    public String getKeyV2() {
        SecretKey b11 = h.f47575a.b();
        if (b11 == null) {
            return null;
        }
        return HexUtil.byteArray2HexStr(b11.getEncoded());
    }
}
