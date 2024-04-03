package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzdna {
    private final zzdob zza;
    @Nullable
    private final zzcop zzb;

    public zzdna(zzdob zzdob, @Nullable zzcop zzcop) {
        this.zza = zzdob;
        this.zzb = zzcop;
    }

    public static final zzdlw<zzdlo> zzh(zzdog zzdog) {
        return new zzdlw<>(zzdog, zzcjm.zzf);
    }

    @Nullable
    public final View zza() {
        zzcop zzcop = this.zzb;
        if (zzcop == null) {
            return null;
        }
        return zzcop.zzI();
    }

    @Nullable
    public final View zzb() {
        zzcop zzcop = this.zzb;
        if (zzcop != null) {
            return zzcop.zzI();
        }
        return null;
    }

    @Nullable
    public final zzcop zzc() {
        return this.zzb;
    }

    public final zzdlw<zzdjh> zzd(Executor executor) {
        return new zzdlw<>(new zzdmz(this.zzb), executor);
    }

    public final zzdob zze() {
        return this.zza;
    }

    public Set<zzdlw<zzder>> zzf(zzddr zzddr) {
        return Collections.singleton(new zzdlw(zzddr, zzcjm.zzf));
    }

    public Set<zzdlw<zzdlo>> zzg(zzddr zzddr) {
        return Collections.singleton(new zzdlw(zzddr, zzcjm.zzf));
    }
}
