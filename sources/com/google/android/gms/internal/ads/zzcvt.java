package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

public final class zzcvt implements zzcvr {
    private final zzg zza;

    public zzcvt(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map<String, String> map) {
        this.zza.zzv(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
