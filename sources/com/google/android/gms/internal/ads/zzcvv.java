package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

public final class zzcvv implements zzcvr {
    private final zzg zza;

    public zzcvv(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map<String, String> map) {
        this.zza.zzx(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
