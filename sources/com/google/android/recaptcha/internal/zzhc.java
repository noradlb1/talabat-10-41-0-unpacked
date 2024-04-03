package com.google.android.recaptcha.internal;

final class zzhc implements zzgu {
    final int zza;
    final zzkm zzb;

    public zzhc(zzhi zzhi, int i11, zzkm zzkm, boolean z11, boolean z12) {
        this.zza = i11;
        this.zzb = zzkm;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzhc) obj).zza;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzio zzb(zzio zzio, zzip zzip) {
        ((zzgz) zzio).zzg((zzhf) zzip);
        return zzio;
    }

    public final zziu zzc(zziu zziu, zziu zziu2) {
        throw new UnsupportedOperationException();
    }

    public final zzkm zzd() {
        return this.zzb;
    }

    public final zzkn zze() {
        return this.zzb.zza();
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg() {
        return false;
    }
}
