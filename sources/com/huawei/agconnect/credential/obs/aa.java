package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.common.api.AgcCrypto;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.agconnect.datastore.annotation.SharedPreference;
import com.newrelic.agent.android.payload.PayloadController;

public class aa implements Token {
    @SharedPreference(crypto = AgcCrypto.class, fileName = "com.huawei.agconnect", isDynamic = true, key = "expires")
    long expires;
    @SharedPreference(crypto = AgcCrypto.class, fileName = "com.huawei.agconnect", isDynamic = true, key = "tokenString")
    String tokenString;
    @SharedPreference(crypto = AgcCrypto.class, fileName = "com.huawei.agconnect", isDynamic = true, key = "validTime")
    long validTime = 0;

    public aa() {
    }

    public aa(String str, long j11) {
        a(str, j11);
    }

    private void a(String str, long j11) {
        this.tokenString = str;
        this.expires = j11;
        this.validTime = (System.currentTimeMillis() + (j11 * 1000)) - PayloadController.PAYLOAD_REQUEUE_PERIOD_MS;
    }

    public boolean a() {
        return this.tokenString != null && System.currentTimeMillis() <= this.validTime;
    }

    public long getExpiration() {
        return this.expires;
    }

    public long getIssuedAt() {
        return 0;
    }

    public long getNotBefore() {
        return 0;
    }

    public String getTokenString() {
        return this.tokenString;
    }
}
