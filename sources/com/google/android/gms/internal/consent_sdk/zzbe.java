package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
@UiThread
public final class zzbe extends WebView {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzbj zzb;
    /* access modifiers changed from: private */
    public boolean zzc = false;

    public zzbe(zzbh zzbh, Handler handler, zzbj zzbj) {
        super(zzbh);
        this.zza = handler;
        this.zzb = zzbj;
    }

    public final void zza(String str, JSONObject jSONObject) {
        String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb2.append(str);
        sb2.append("(");
        sb2.append(jSONObject2);
        sb2.append(");");
        this.zza.post(new zzbd(this, sb2.toString()));
    }

    /* access modifiers changed from: private */
    public static boolean zza(@Nullable String str) {
        return str != null && str.startsWith("consent://");
    }
}
