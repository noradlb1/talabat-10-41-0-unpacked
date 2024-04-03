package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzelw implements zzehv<zzfev, zzejq> {
    @GuardedBy("this")
    private final Map<String, zzehw<zzfev, zzejq>> zza = new HashMap();
    private final zzdww zzb;

    public zzelw(zzdww zzdww) {
        this.zzb = zzdww;
    }

    public final zzehw<zzfev, zzejq> zza(String str, JSONObject jSONObject) throws zzfek {
        zzehw<zzfev, zzejq> zzehw;
        synchronized (this) {
            zzehw = this.zza.get(str);
            if (zzehw == null) {
                zzehw = new zzehw<>(this.zzb.zzb(str, jSONObject), new zzejq(), str);
                this.zza.put(str, zzehw);
            }
        }
        return zzehw;
    }
}
