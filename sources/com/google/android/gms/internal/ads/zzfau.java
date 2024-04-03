package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzfau implements zzfpv<zzeeg, zzfax> {
    final /* synthetic */ zzfay zza;

    public zzfau(zzfay zzfay) {
        this.zza = zzfay;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzciz.zzh("", (zzeeg) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfay zzfay = this.zza;
        zzfay.zzd = new zzfax((zzcdq) null, zzfay.zze(), (zzfaw) null);
        return this.zza.zzd;
    }
}
