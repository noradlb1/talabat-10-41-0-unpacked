package com.instabug.survey.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.Address;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.homescreen.network.UrlConstantsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a implements Cacheable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f52392a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52393b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52394c;

    /* renamed from: d  reason: collision with root package name */
    private long f52395d = -1;

    @Nullable
    public String a() {
        return this.f52394c;
    }

    public void a(long j11) {
        this.f52395d = j11;
    }

    public void a(@NonNull String str) {
        this.f52394c = str;
    }

    @Nullable
    public String b() {
        return this.f52392a;
    }

    public void b(@NonNull String str) {
        this.f52392a = str;
    }

    @Nullable
    public String c() {
        return this.f52393b;
    }

    public void c(@NonNull String str) {
        this.f52393b = str;
    }

    public long d() {
        return this.f52395d;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        b(jSONObject.optString("country"));
        c(jSONObject.optString(UrlConstantsKt.PATH_COUNTRY_CODE));
        a(jSONObject.optString(Address.KEY_CITY));
        a(jSONObject.optLong(RemoteMessageConst.TTL));
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("country", (Object) b()).put(UrlConstantsKt.PATH_COUNTRY_CODE, (Object) c()).put(Address.KEY_CITY, (Object) a()).put(RemoteMessageConst.TTL, d());
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        try {
            return toJson();
        } catch (JSONException e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("IBG-Surveys", "Error: " + e11.getMessage() + " while parsing country info", e11);
            }
            return super.toString();
        }
    }
}
