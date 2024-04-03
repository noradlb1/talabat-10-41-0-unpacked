package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

public final class zzfiz {
    private final String zza = zzbms.zzb.zze();

    public final String zza(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zza).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
