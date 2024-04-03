package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final class zzfly extends zzflt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: long} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r3v0, types: [org.json.JSONObject] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzfly(com.google.android.gms.internal.ads.zzflm r8, com.google.android.gms.internal.ads.zzflm r9, java.util.HashSet<java.lang.String> r10, org.json.JSONObject r11, long r12) {
        /*
            r7 = this;
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfly.<init>(com.google.android.gms.internal.ads.zzflm, java.util.HashSet, org.json.JSONObject, long, byte[]):void");
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzflg.zzi(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        JSONObject jSONObject = this.zzb;
        if (!(jSONObject instanceof JSONObject)) {
            return jSONObject.toString();
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zza((String) obj);
    }

    public final void zza(String str) {
        zzfkp zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfkp.zza()) != null) {
            for (zzfke next : zza.zzc()) {
                if (this.zza.contains(next.zzh())) {
                    next.zzg().zze(str, this.zzc);
                }
            }
        }
        super.zza(str);
    }
}
