package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzded {
    private final Context zza;
    private final zzfef zzb;
    private final Bundle zzc;
    @Nullable
    private final zzfea zzd;

    public /* synthetic */ zzded(zzdeb zzdeb, zzdec zzdec) {
        this.zza = zzdeb.zza;
        this.zzb = zzdeb.zzb;
        this.zzc = zzdeb.zzc;
        this.zzd = zzdeb.zzd;
    }

    public final Context zza(Context context) {
        return this.zza;
    }

    @Nullable
    public final Bundle zzb() {
        return this.zzc;
    }

    public final zzdeb zzc() {
        zzdeb zzdeb = new zzdeb();
        zzdeb.zzc(this.zza);
        zzdeb.zzf(this.zzb);
        zzdeb.zzd(this.zzc);
        return zzdeb;
    }

    @Nullable
    public final zzfea zzd() {
        return this.zzd;
    }

    public final zzfef zze() {
        return this.zzb;
    }
}
