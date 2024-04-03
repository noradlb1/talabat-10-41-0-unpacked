package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

final class zzayw implements ValueCallback<String> {
    final /* synthetic */ zzayx zza;

    public zzayw(zzayx zzayx) {
        this.zza = zzayx;
    }

    /* renamed from: zza */
    public final void onReceiveValue(String str) {
        zzayx zzayx = this.zza;
        zzayx.zze.zzd(zzayx.zzb, zzayx.zzc, str, zzayx.zzd);
    }
}
