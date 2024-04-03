package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzerm implements zzevm<Bundle> {
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final float zzg;
    public final boolean zzh;

    public zzerm(int i11, boolean z11, boolean z12, int i12, int i13, int i14, float f11, boolean z13) {
        this.zza = i11;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = f11;
        this.zzh = z13;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zza);
        bundle.putBoolean("ma", this.zzb);
        bundle.putBoolean("sp", this.zzc);
        bundle.putInt("muv", this.zzd);
        bundle.putInt("rm", this.zze);
        bundle.putInt("riv", this.zzf);
        bundle.putFloat("android_app_volume", this.zzg);
        bundle.putBoolean("android_app_muted", this.zzh);
    }
}
