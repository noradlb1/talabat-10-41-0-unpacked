package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements AesDecrypt {

    /* renamed from: a  reason: collision with root package name */
    private final Context f47510a;

    /* renamed from: b  reason: collision with root package name */
    private final String f47511b;

    /* renamed from: c  reason: collision with root package name */
    private IDecrypt f47512c;

    public h(Context context, String str) {
        this.f47510a = context;
        this.f47511b = str;
    }

    public String decrypt(String str, String str2) {
        if (this.f47512c == null) {
            this.f47512c = decryptComponent();
        }
        if (this.f47512c == null) {
            Log.w("AGC_FlexibleDecrypt", "decrypt Flexible Decrypt error, use old instead");
            this.f47512c = new g(this.f47510a, this.f47511b).decryptComponent();
        }
        return this.f47512c.decrypt(l.a(this.f47510a, this.f47511b, "agc_plugin_", str), str2);
    }

    public IDecrypt decryptComponent() {
        String a11 = l.a(this.f47510a, this.f47511b, "agc_plugin_", "crypto_component");
        if (a11 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(a11), "utf-8"));
            return new f(new d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e11) {
            Log.e("AGC_FlexibleDecrypt", "FlexibleDecrypt exception: " + e11.getMessage());
            return null;
        }
    }
}
