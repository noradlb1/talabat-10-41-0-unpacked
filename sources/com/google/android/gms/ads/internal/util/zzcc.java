package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcje;

public final class zzcc extends zzb {
    private final zzcje zza;
    private final String zzb;

    public zzcc(Context context, String str, String str2) {
        this.zza = new zzcje(zzt.zzp().zzd(context, str));
        this.zzb = str2;
    }

    public final void zza() {
        this.zza.zza(this.zzb);
    }
}
