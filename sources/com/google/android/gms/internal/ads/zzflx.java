package com.google.android.gms.internal.ads;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final class zzflx extends zzflt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: long} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r3v0, types: [org.json.JSONObject] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzflx(com.google.android.gms.internal.ads.zzflm r8, com.google.android.gms.internal.ads.zzflm r9, java.util.HashSet<java.lang.String> r10, org.json.JSONObject r11, long r12) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzflx.<init>(com.google.android.gms.internal.ads.zzflm, java.util.HashSet, org.json.JSONObject, long, byte[]):void");
    }

    private final void zzc(String str) {
        zzfkp zza = zzfkp.zza();
        if (zza != null) {
            for (zzfke next : zza.zzc()) {
                if (this.zza.contains(next.zzh())) {
                    next.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        JSONObject jSONObject = this.zzb;
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.zza(str);
    }

    public final void zza(String str) {
        zzc(str);
        super.zza(str);
    }
}
