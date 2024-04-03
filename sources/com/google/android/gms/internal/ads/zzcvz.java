package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzcvz implements zzcvr {
    private final zzebt zza;

    public zzcvz(zzebt zzebt) {
        this.zza = zzebt;
    }

    public final void zza(Map<String, String> map) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgQ)).booleanValue()) {
            String str = map.get("policy_violations");
            if (!TextUtils.isEmpty(str)) {
                this.zza.zzk(str);
            }
        }
    }
}
