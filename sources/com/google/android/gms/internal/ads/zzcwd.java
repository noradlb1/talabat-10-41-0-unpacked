package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzcwd implements zzcvr {
    private final zzfdm zza;

    public zzcwd(zzfdm zzfdm) {
        this.zza = zzfdm;
    }

    public final void zza(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zza.zzb(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
