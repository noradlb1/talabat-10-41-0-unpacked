package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final /* synthetic */ class zzbul {
    public static void zza(zzbum zzbum, String str, Map map) {
        try {
            zzbum.zze(str, zzt.zzp().zzf(map));
        } catch (JSONException unused) {
            zzciz.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbum zzbum, String str, JSONObject jSONObject) {
        String str2;
        String str3;
        if (!(jSONObject instanceof JSONObject)) {
            str2 = jSONObject.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(jSONObject);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb2.append(str);
        sb2.append("',");
        sb2.append(str2);
        sb2.append(");");
        String sb3 = sb2.toString();
        if (sb3.length() != 0) {
            str3 = "Dispatching AFMA event: ".concat(sb3);
        } else {
            str3 = new String("Dispatching AFMA event: ");
        }
        zzciz.zze(str3);
        zzbum.zza(sb2.toString());
    }

    public static void zzc(zzbum zzbum, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("(");
        sb2.append(str2);
        sb2.append(");");
        zzbum.zza(sb2.toString());
    }

    public static void zzd(zzbum zzbum, String str, JSONObject jSONObject) {
        String str2;
        if (!(jSONObject instanceof JSONObject)) {
            str2 = jSONObject.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(jSONObject);
        }
        zzbum.zzb(str, str2);
    }
}
