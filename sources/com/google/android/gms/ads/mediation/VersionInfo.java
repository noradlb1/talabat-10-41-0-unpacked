package com.google.android.gms.ads.mediation;

public final class VersionInfo {
    private final int zza;
    private final int zzb;
    private final int zzc;

    public VersionInfo(int i11, int i12, int i13) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
    }

    public int getMajorVersion() {
        return this.zza;
    }

    public int getMicroVersion() {
        return this.zzc;
    }

    public int getMinorVersion() {
        return this.zzb;
    }
}
