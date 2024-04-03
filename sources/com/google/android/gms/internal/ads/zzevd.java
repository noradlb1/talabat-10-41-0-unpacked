package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.firebase.perf.FirebasePerformance;

public final class zzevd implements zzevm<Bundle> {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;

    public zzevd(boolean z11, boolean z12, String str, boolean z13, int i11, int i12, int i13) {
        this.zza = z11;
        this.zzb = z12;
        this.zzc = str;
        this.zzd = z13;
        this.zze = i11;
        this.zzf = i12;
        this.zzg = i13;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzbgq.zzc().zzb(zzblj.zzcn));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt("lv", this.zzg);
        Bundle zza2 = zzfeq.zza(bundle, "sdk_env");
        zza2.putBoolean("mf", zzbmx.zza.zze().booleanValue());
        zza2.putBoolean("instant_app", this.zza);
        zza2.putBoolean("lite", this.zzb);
        zza2.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", zza2);
        Bundle zza3 = zzfeq.zza(zza2, "build_meta");
        zza3.putString("cl", "428884702");
        zza3.putString("rapid_rc", "dev");
        zza3.putString("rapid_rollup", FirebasePerformance.HttpMethod.HEAD);
        zza2.putBundle("build_meta", zza3);
    }
}
