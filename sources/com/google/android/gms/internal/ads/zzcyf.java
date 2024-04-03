package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

public final class zzcyf extends zzdav {
    private final View zzc;
    @Nullable
    private final zzcop zzd;
    private final zzfdo zze;
    private final int zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final zzcxx zzi;
    @Nullable
    private zzazx zzj;

    public zzcyf(zzdau zzdau, View view, @Nullable zzcop zzcop, zzfdo zzfdo, int i11, boolean z11, boolean z12, zzcxx zzcxx) {
        super(zzdau);
        this.zzc = view;
        this.zzd = zzcop;
        this.zze = zzfdo;
        this.zzf = i11;
        this.zzg = z11;
        this.zzh = z12;
        this.zzi = zzcxx;
    }

    public final int zza() {
        return this.zzf;
    }

    public final View zzb() {
        return this.zzc;
    }

    public final zzfdo zzc() {
        return zzfej.zzb(this.zzb.zzs, this.zze);
    }

    public final void zzd(zzazn zzazn) {
        this.zzd.zzaj(zzazn);
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzd.zzay();
    }

    public final boolean zzh() {
        if (this.zzd.zzP() == null || !this.zzd.zzP().zzJ()) {
            return false;
        }
        return true;
    }

    public final void zzi(long j11, int i11) {
        this.zzi.zza(j11, i11);
    }

    @Nullable
    public final zzazx zzj() {
        return this.zzj;
    }

    public final void zzk(zzazx zzazx) {
        this.zzj = zzazx;
    }
}
