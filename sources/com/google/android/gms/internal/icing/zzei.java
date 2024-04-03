package com.google.android.gms.internal.icing;

import java.io.IOException;

final class zzei<T> implements zzep<T> {
    private final zzee zza;
    private final zzfd<?, ?> zzb;
    private final boolean zzc;
    private final zzcq<?> zzd;

    private zzei(zzfd<?, ?> zzfd, zzcq<?> zzcq, zzee zzee) {
        this.zzb = zzfd;
        this.zzc = zzcq.zza(zzee);
        this.zzd = zzcq;
        this.zza = zzee;
    }

    public static <T> zzei<T> zzg(zzfd<?, ?> zzfd, zzcq<?> zzcq, zzee zzee) {
        return new zzei<>(zzfd, zzcq, zzee);
    }

    public final boolean zza(T t11, T t12) {
        if (!this.zzb.zzb(t11).equals(this.zzb.zzb(t12))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t11);
        this.zzd.zzb(t12);
        throw null;
    }

    public final int zzb(T t11) {
        int hashCode = this.zzb.zzb(t11).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zzb(t11);
        throw null;
    }

    public final void zzc(T t11, T t12) {
        zzer.zzF(this.zzb, t11, t12);
        if (this.zzc) {
            zzer.zzE(this.zzd, t11, t12);
        }
    }

    public final int zzd(T t11) {
        zzfd<?, ?> zzfd = this.zzb;
        int zze = zzfd.zze(zzfd.zzb(t11));
        if (!this.zzc) {
            return zze;
        }
        this.zzd.zzb(t11);
        throw null;
    }

    public final void zze(T t11) {
        this.zzb.zzc(t11);
        this.zzd.zzc(t11);
    }

    public final boolean zzf(T t11) {
        this.zzd.zzb(t11);
        throw null;
    }

    public final void zzi(T t11, zzcn zzcn) throws IOException {
        this.zzd.zzb(t11);
        throw null;
    }
}
