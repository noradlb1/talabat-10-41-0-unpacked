package com.google.android.libraries.places.internal;

import java.io.IOException;

final class zzadd<T> implements zzadk<T> {
    private final zzacz zza;
    private final zzaeb<?, ?> zzb;
    private final boolean zzc;
    private final zzabi<?> zzd;

    private zzadd(zzaeb<?, ?> zzaeb, zzabi<?> zzabi, zzacz zzacz) {
        this.zzb = zzaeb;
        this.zzc = zzabi.zzc(zzacz);
        this.zzd = zzabi;
        this.zza = zzacz;
    }

    public static <T> zzadd<T> zzg(zzaeb<?, ?> zzaeb, zzabi<?> zzabi, zzacz zzacz) {
        return new zzadd<>(zzaeb, zzabi, zzacz);
    }

    public final int zza(T t11) {
        zzaeb<?, ?> zzaeb = this.zzb;
        int zzb2 = zzaeb.zzb(zzaeb.zzc(t11));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(t11);
        throw null;
    }

    public final int zzb(T t11) {
        int hashCode = this.zzb.zzc(t11).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(t11);
        throw null;
    }

    public final void zzc(T t11) {
        this.zzb.zze(t11);
        this.zzd.zzb(t11);
    }

    public final void zzd(T t11, T t12) {
        zzadm.zzD(this.zzb, t11, t12);
        if (this.zzc) {
            zzadm.zzC(this.zzd, t11, t12);
        }
    }

    public final boolean zze(T t11, T t12) {
        if (!this.zzb.zzc(t11).equals(this.zzb.zzc(t12))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(t11);
        this.zzd.zza(t12);
        throw null;
    }

    public final boolean zzf(T t11) {
        this.zzd.zza(t11);
        throw null;
    }

    public final void zzi(T t11, zzabg zzabg) throws IOException {
        this.zzd.zza(t11);
        throw null;
    }
}
