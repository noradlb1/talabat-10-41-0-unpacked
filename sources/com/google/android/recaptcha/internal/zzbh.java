package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzbh {
    public zzm zza;
    @NotNull
    private final zzbj zzb;
    @NotNull
    private String zzc = "recaptcha.m.Main.rge";
    private int zzd;
    @NotNull
    private final zzbi zze;
    @NotNull
    private final zzbb zzf;
    @NotNull
    private final zzn zzg;
    @NotNull
    private final zzm zzh;

    public zzbh(@NotNull zzbj zzbj) {
        this.zzb = zzbj;
        this.zze = zzbj.zzd();
        this.zzf = zzbj.zzc();
        this.zzg = zzbj.zzb();
        this.zzh = new zzm();
    }

    public final byte zza() {
        return this.zzb.zza();
    }

    public final int zzb() {
        return this.zzd;
    }

    @NotNull
    public final zzm zzc() {
        return this.zzh;
    }

    @NotNull
    public final zzbb zzd() {
        return this.zzf;
    }

    @NotNull
    public final zzbi zze() {
        return this.zze;
    }

    @NotNull
    public final String zzf() {
        return this.zzc;
    }

    public final void zzg() {
        this.zzb.zze();
    }

    public final void zzh(@NotNull String str) {
        this.zzc = str;
    }

    public final void zzi(int i11) {
        this.zzd = i11;
    }

    public final void zzj(byte b11) {
        this.zzb.zzf(b11);
    }
}
