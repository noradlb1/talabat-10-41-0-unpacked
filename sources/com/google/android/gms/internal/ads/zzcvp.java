package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzcvp {
    private final Map<String, zzcvs> zza;
    private final Map<String, zzcvr> zzb;

    public zzcvp(Map<String, zzcvs> map, Map<String, zzcvr> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfdz zzfdz) throws Exception {
        for (zzfdx next : zzfdz.zzb.zzc) {
            if (this.zza.containsKey(next.zza)) {
                this.zza.get(next.zza).zza(next.zzb);
            } else if (this.zzb.containsKey(next.zza)) {
                zzcvr zzcvr = this.zzb.get(next.zza);
                JSONObject jSONObject = next.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    String optString = jSONObject.optString(next2);
                    if (optString != null) {
                        hashMap.put(next2, optString);
                    }
                }
                zzcvr.zza(hashMap);
            }
        }
    }
}
