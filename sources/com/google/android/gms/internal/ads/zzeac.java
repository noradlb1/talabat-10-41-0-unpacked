package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
final class zzeac {
    /* access modifiers changed from: private */
    @Nullable
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    @Nullable
    public String zzc;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzd;
    /* access modifiers changed from: private */
    @Nullable
    public String zze;
    /* access modifiers changed from: private */
    @Nullable
    public Integer zzf;

    public /* synthetic */ zzeac(String str, zzeab zzeab) {
        this.zzb = str;
    }

    public static /* bridge */ /* synthetic */ String zza(zzeac zzeac) {
        String str = (String) zzbgq.zzc().zzb(zzblj.zzgX);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzeac.zza);
            jSONObject.put("eventCategory", (Object) zzeac.zzb);
            jSONObject.putOpt("event", zzeac.zzc);
            jSONObject.putOpt("errorCode", zzeac.zzd);
            jSONObject.putOpt("rewardType", zzeac.zze);
            jSONObject.putOpt("rewardAmount", zzeac.zzf);
        } catch (JSONException unused) {
            zzciz.zzj("Could not convert parameters to JSON.");
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(jSONObjectInstrumentation).length());
        sb2.append(str);
        sb2.append("(\"h5adsEvent\",");
        sb2.append(jSONObjectInstrumentation);
        sb2.append(");");
        return sb2.toString();
    }
}
