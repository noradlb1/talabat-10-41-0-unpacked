package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final /* synthetic */ class zzczb implements zzdgf {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcjf zzb;
    public final /* synthetic */ zzfdn zzc;
    public final /* synthetic */ zzfef zzd;

    public /* synthetic */ zzczb(Context context, zzcjf zzcjf, zzfdn zzfdn, zzfef zzfef) {
        this.zza = context;
        this.zzb = zzcjf;
        this.zzc = zzfdn;
        this.zzd = zzfef;
    }

    public final void zzn() {
        String str;
        Context context = this.zza;
        zzcjf zzcjf = this.zzb;
        zzfdn zzfdn = this.zzc;
        zzfef zzfef = this.zzd;
        zzba zzs = zzt.zzs();
        String str2 = zzcjf.zza;
        JSONObject jSONObject = zzfdn.zzD;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        zzs.zzn(context, str2, str, zzfef.zzf);
    }
}
