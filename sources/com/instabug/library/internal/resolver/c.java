package com.instabug.library.internal.resolver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.model.h;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f51005c;

    /* renamed from: a  reason: collision with root package name */
    private b f51006a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile h f51007b;

    private c() {
        d();
        c();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f51005c == null) {
                f51005c = new c();
            }
            cVar = f51005c;
        }
        return cVar;
    }

    private void c() {
        String loggingFeatureSettings;
        try {
            if (this.f51007b == null && (loggingFeatureSettings = SettingsManager.getInstance().getLoggingFeatureSettings()) != null) {
                h hVar = new h();
                hVar.fromJson(loggingFeatureSettings);
                this.f51007b = hVar;
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", e11.toString(), e11);
        }
    }

    private void d() {
        this.f51006a = new a(this);
    }

    public void b(@Nullable JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            this.f51007b = new h();
            a(0);
            SettingsManager.getInstance().setLoggingFeatureSettings((String) null);
            return;
        }
        this.f51007b = a(jSONObject);
        SettingsManager.getInstance().setLoggingFeatureSettings(JSONObjectInstrumentation.toString(jSONObject));
        if (this.f51007b != null) {
            a(this.f51007b.d());
        }
    }

    private h a(@NonNull JSONObject jSONObject) throws JSONException {
        h hVar = new h();
        hVar.b(jSONObject);
        return hVar;
    }

    private void a(int i11) {
        if (this.f51006a == null) {
            d();
        }
        this.f51006a.a(i11);
    }

    @Nullable
    public h b() {
        return this.f51007b;
    }
}
