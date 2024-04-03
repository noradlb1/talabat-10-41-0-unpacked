package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;

final class zzcou implements zzfwm<Map<String, String>> {
    final /* synthetic */ List zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Uri zzc;
    final /* synthetic */ zzcow zzd;

    public zzcou(zzcow zzcow, List list, String str, Uri uri) {
        this.zzd = zzcow;
        this.zza = list;
        this.zzb = str;
        this.zzc = uri;
    }

    public final void zza(Throwable th2) {
        zzciz.zzj("Failed to parse gmsg params for: ".concat(String.valueOf(this.zzc)));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzO((Map) obj, this.zza, this.zzb);
    }
}
