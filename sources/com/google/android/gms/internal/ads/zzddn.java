package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzaw;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final /* synthetic */ class zzddn implements zzfpv {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcjf zzb;
    public final /* synthetic */ zzfef zzc;

    public /* synthetic */ zzddn(Context context, zzcjf zzcjf, zzfef zzfef) {
        this.zza = context;
        this.zzb = zzcjf;
        this.zzc = zzfef;
    }

    public final Object apply(Object obj) {
        String str;
        Context context = this.zza;
        zzcjf zzcjf = this.zzb;
        zzfef zzfef = this.zzc;
        zzfdn zzfdn = (zzfdn) obj;
        zzaw zzaw = new zzaw(context);
        zzaw.zzp(zzfdn.zzC);
        JSONObject jSONObject = zzfdn.zzD;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        zzaw.zzq(str);
        zzaw.zzo(zzcjf.zza);
        zzaw.zzn(zzfef.zzf);
        return zzaw;
    }
}
