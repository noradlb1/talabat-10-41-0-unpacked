package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzcc;
import java.util.Map;

public final /* synthetic */ class zzbrb implements zzbrt {
    public static final /* synthetic */ zzbrb zza = new zzbrb();

    private /* synthetic */ zzbrb() {
    }

    public final void zza(Object obj, Map map) {
        zzcpq zzcpq = (zzcpq) obj;
        zzbrt<zzcop> zzbrt = zzbrs.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzciz.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzcc(zzcpq.getContext(), ((zzcpy) zzcpq).zzp().zza, str).zzb();
        }
    }
}
