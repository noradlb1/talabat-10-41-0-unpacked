package com.instabug.library.model;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class b implements Cacheable {

    /* renamed from: a  reason: collision with root package name */
    private long f51510a;

    /* renamed from: b  reason: collision with root package name */
    private String f51511b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51512c;

    public b(long j11, String str, @Nullable String str2) {
        this.f51510a = j11;
        this.f51511b = str;
        this.f51512c = str2;
    }

    public void a(long j11) {
        this.f51510a = j11;
    }

    public String b() {
        return this.f51511b;
    }

    public long c() {
        return this.f51510a;
    }

    public void fromJson(@Nullable String str) throws JSONException {
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            a((long) jSONObject.optInt(RemoteMessageConst.TTL, 0));
            b(jSONObject.optString("sdk_version", ""));
            a(jSONObject.optString("hash", ""));
            return;
        }
        a(0);
        b("");
        a("");
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(RemoteMessageConst.TTL, c());
        jSONObject.put("sdk_version", (Object) b());
        String a11 = a();
        if (a11 != null) {
            jSONObject.put("hash", (Object) a11);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @Nullable
    public String a() {
        return this.f51512c;
    }

    public void b(String str) {
        this.f51511b = str;
    }

    public void a(@Nullable String str) {
        this.f51512c = str;
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    public b() {
    }
}
