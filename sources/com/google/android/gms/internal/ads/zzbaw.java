package com.google.android.gms.internal.ads;

import java.io.InputStream;

public final class zzbaw {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzbaw(InputStream inputStream, boolean z11, boolean z12, long j11, boolean z13) {
        this.zza = inputStream;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = j11;
        this.zze = z13;
    }

    public static zzbaw zzb(InputStream inputStream, boolean z11, boolean z12, long j11, boolean z13) {
        return new zzbaw(inputStream, z11, z12, j11, z13);
    }

    public final long zza() {
        return this.zzd;
    }

    public final InputStream zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
