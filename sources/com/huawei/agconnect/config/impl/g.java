package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;

public class g implements AesDecrypt {

    /* renamed from: a  reason: collision with root package name */
    private final Context f47507a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47508b;

    /* renamed from: c  reason: collision with root package name */
    private IDecrypt f47509c;

    public g(Context context, String str) {
        this.f47507a = context;
        this.f47508b = str;
    }

    public String decrypt(String str, String str2) {
        if (this.f47509c == null) {
            this.f47509c = decryptComponent();
        }
        return this.f47509c.decrypt(l.a(this.f47507a, this.f47508b, "agc_", str), str2);
    }

    public IDecrypt decryptComponent() {
        return new f(new d(l.a(this.f47507a, this.f47508b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), l.a(this.f47507a, this.f47508b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), l.a(this.f47507a, this.f47508b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), l.a(this.f47507a, this.f47508b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", 5000));
    }
}
