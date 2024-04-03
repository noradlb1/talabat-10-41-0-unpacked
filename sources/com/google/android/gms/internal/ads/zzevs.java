package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.apptimize.hl;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzevs implements zzevm<Bundle> {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final ArrayList<String> zzh;
    public final String zzi;
    public final String zzj;
    public final String zzk;
    public final boolean zzl;
    public final String zzm;
    public final long zzn;

    public zzevs(boolean z11, boolean z12, String str, boolean z13, boolean z14, boolean z15, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z16, String str6, long j11) {
        this.zza = z11;
        this.zzb = z12;
        this.zzc = str;
        this.zzd = z13;
        this.zze = z14;
        this.zzf = z15;
        this.zzg = str2;
        this.zzh = arrayList;
        this.zzi = str3;
        this.zzj = str4;
        this.zzk = str5;
        this.zzl = z16;
        this.zzm = str6;
        this.zzn = j11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zza);
        bundle.putBoolean("coh", this.zzb);
        bundle.putString("gl", this.zzc);
        bundle.putBoolean("simulator", this.zzd);
        bundle.putBoolean("is_latchsky", this.zze);
        bundle.putBoolean("is_sidewinder", this.zzf);
        bundle.putString(hl.f42949a, this.zzg);
        if (!this.zzh.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzh);
        }
        bundle.putString("mv", this.zzi);
        bundle.putString("submodel", this.zzm);
        Bundle zza2 = zzfeq.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        zza2.putString("build", this.zzk);
        zza2.putLong("remaining_data_partition_space", this.zzn);
        Bundle zza3 = zzfeq.zza(zza2, "browser");
        zza2.putBundle("browser", zza3);
        zza3.putBoolean("is_browser_custom_tabs_capable", this.zzl);
        if (!TextUtils.isEmpty(this.zzj)) {
            Bundle zza4 = zzfeq.zza(zza2, "play_store");
            zza2.putBundle("play_store", zza4);
            zza4.putString("package_version", this.zzj);
        }
    }
}
