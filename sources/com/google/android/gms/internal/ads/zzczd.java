package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

public class zzczd {
    private final zzdat zza;
    private final View zzb;
    private final zzfdo zzc;
    private final zzcop zzd;

    public zzczd(View view, @Nullable zzcop zzcop, zzdat zzdat, zzfdo zzfdo) {
        this.zzb = view;
        this.zzd = zzcop;
        this.zza = zzdat;
        this.zzc = zzfdo;
    }

    public static final zzdlw<zzdgf> zzf(Context context, zzcjf zzcjf, zzfdn zzfdn, zzfef zzfef) {
        return new zzdlw<>(new zzczb(context, zzcjf, zzfdn, zzfef), zzcjm.zzf);
    }

    public static final Set<zzdlw<zzdgf>> zzg(zzdan zzdan) {
        return Collections.singleton(new zzdlw(zzdan, zzcjm.zzf));
    }

    public static final zzdlw<zzdgf> zzh(zzdal zzdal) {
        return new zzdlw<>(zzdal, zzcjm.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    @Nullable
    public final zzcop zzb() {
        return this.zzd;
    }

    public final zzdat zzc() {
        return this.zza;
    }

    public zzdgd zzd(Set<zzdlw<zzdgf>> set) {
        return new zzdgd(set);
    }

    public final zzfdo zze() {
        return this.zzc;
    }
}
