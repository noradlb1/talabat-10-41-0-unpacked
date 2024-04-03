package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

public final class zzddx {
    private final zzfie zza;
    private final zzcjf zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List<String> zze;
    private final PackageInfo zzf;
    private final zzgpl<zzfxa<String>> zzg;
    private final String zzh;
    private final zzevq<Bundle> zzi;

    public zzddx(zzfie zzfie, zzcjf zzcjf, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, zzgpl<zzfxa<String>> zzgpl, zzg zzg2, String str2, zzevq<Bundle> zzevq) {
        this.zza = zzfie;
        this.zzb = zzcjf;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzgpl;
        this.zzh = str2;
        this.zzi = zzevq;
    }

    public final /* synthetic */ zzcdq zza(zzfxa zzfxa) throws Exception {
        return new zzcdq((Bundle) zzfxa.get(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (String) this.zzg.zzb().get(), this.zzh, (zzffu) null, (String) null);
    }

    public final zzfxa<Bundle> zzb() {
        zzfie zzfie = this.zza;
        return zzfho.zzc(this.zzi.zza(new Bundle()), zzfhy.SIGNALS, zzfie).zza();
    }

    public final zzfxa<zzcdq> zzc() {
        zzfxa<Bundle> zzb2 = zzb();
        return this.zza.zza(zzfhy.REQUEST_PARCEL, zzb2, this.zzg.zzb()).zza(new zzddw(this, zzb2)).zza();
    }
}
