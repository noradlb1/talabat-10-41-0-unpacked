package com.instabug.library.internal.resolver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.nonfatals.settings.a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f51008b;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private volatile a f51009a;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f51008b == null) {
                f51008b = new d();
            }
            dVar = f51008b;
        }
        return dVar;
    }

    public void b(@Nullable JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            this.f51009a = null;
            return;
        }
        this.f51009a = a(jSONObject);
        SettingsManager.getInstance().setNonFatalsFeatureSettings(JSONObjectInstrumentation.toString(jSONObject));
    }

    @Nullable
    private a a(@NonNull JSONObject jSONObject) throws JSONException {
        new a().b(jSONObject);
        return this.f51009a;
    }

    @Nullable
    public a b() {
        try {
            String nonFatalsFeatureSettings = SettingsManager.getInstance().getNonFatalsFeatureSettings();
            if (nonFatalsFeatureSettings != null) {
                a aVar = new a();
                aVar.a(nonFatalsFeatureSettings);
                this.f51009a = aVar;
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while getting NonFatals settings", e11);
        }
        return this.f51009a;
    }
}
